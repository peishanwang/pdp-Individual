package edu.neu.ccs.cs5010;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * EmailGenerator is used to generate a email by importing email-template,
 * customers' data, output directory, and event.
 */
public class EmailGenerator implements IEmailGenerator{
  private IGeneralData generalData;
  private ICustomerData personalData;
  private String outputDir;
  private String templatePath;
  private static int emailNum;
  private final static int SAVE_OUTPUT = 0;
  private final static int SEND_EMAIL = 1;
  private final static int SELECTED_TYPE = SAVE_OUTPUT;
  private final static int NEEDED_ARGUMENTS = 4;

  /**
   * Constructor of EmailGenerator
   * @param gd general data
   * @param csv csv file path
   * @param items information needed to extract from csv file
   * @param outputDir output directory path
   * @param templatePath template file path
   */
  public EmailGenerator(IGeneralData gd, String csv, List<String> items, String outputDir, String templatePath) {
    generalData = gd;
    personalData = new CustomerData(csv, items);
    emailNum = 1;
    this.outputDir = outputDir;
    this.templatePath = templatePath;
  }

  /**
   * Main method to handle arguments and generate email
   * @param args input arguments
   */
  public static void main(String args[]) {
    String outputDir = "";
    String templatePath = "";
    String csvPath = "";
    List<String> items = new ArrayList<>();
    items.add("first_name");
    items.add("last_name");
    items.add("email");
    items.add("rewards");

    String event = "";
    String departureCity = "";
    String destinationCity = "";
    String arg;
    int i = 0;
    int countArgs = 0;
    while (i < args.length && args[i].startsWith("--")) {
      arg = args[i++];
      if (arg.equals("--email-template")) {
        if (i < args.length) {
          templatePath = args[i++];
          countArgs++;
        } else {
          throw new LackOfArgumentException("--email-template is given without providing appropriate arguments");
        }
        System.out.println("email template = " + templatePath);
      } else if (arg.equals("--output-dir")) {
        if (i < args.length) {
          outputDir = args[i++];
          countArgs++;
        } else {
          throw new LackOfArgumentException("--output-dir is given without providing appropriate arguments");
        }
        System.out.println("output file = " + outputDir);
      } else if (arg.equals("--csv-file")) {
        if (i < args.length) {
          csvPath = args[i++];
          countArgs++;
        } else {
          throw new LackOfArgumentException("--csv-file is given without providing appropriate arguments");
        }
        System.out.println("csv file = " + csvPath);
      } else if (arg.equals("--event")) {
        if (i < args.length) {
          event = args[i++];
          countArgs++;
        } else {
          throw new LackOfArgumentException("--event is given without providing appropriate arguments");
        }
        System.out.println("event = " + event);
      }
    }
    if (countArgs != NEEDED_ARGUMENTS) throw new LackOfArgumentException("Not enough arguments :" + countArgs);
    Pattern pattern = Pattern.compile("From(.*?)To(.*?).csv");
    Matcher matcher = pattern.matcher(csvPath);
    if (matcher.find() && !matcher.group(1).equals("") && !matcher.group(1).equals("")) {
      departureCity = matcher.group(1);
      destinationCity = matcher.group(2);
    } else {
      throw new LackOfArgumentException("--csv-file argument does not contain departure-city and destination-city");
    }
    IGeneralData genData = new GeneralData(event, getCurrentDate(), departureCity, destinationCity);
    IEmailGenerator emailGen = new EmailGenerator(genData, csvPath, items, outputDir, templatePath);
    emailGen.generateEmail(SELECTED_TYPE);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void generateEmail(int outputType) {
    ITxtToList ttl = new TxtToList(templatePath);
    List<String> template = ttl.getList();
    int totalCustomers = personalData.getSize();
    HashMap<String, List<String>> allCusData = personalData.getData();
    ITemplateModifier tm = new TemplateModifier(template);
    for (int i = 0; i < totalCustomers; i++) {
      HashMap<String, String> personalData = new HashMap<>();
      for (String key : allCusData.keySet()) {
        personalData.put(key, allCusData.get(key).get(i));
      }
      personalData.putAll(generalData.getMap());
      List<String> result = tm.modifyTemplate(personalData);
      if (outputType == SAVE_OUTPUT) {
        generateOutput(result);
      } else if (outputType == SEND_EMAIL) {
        EmailFormat ef = new EmailFormat(result);
        EmailSender.sendEmail(ef);
      }
    }
  }

  /**
   * Returns current date in specific format
   * @return current date in specific format
   */
  private static String getCurrentDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date();
    String date = sdf.format(now);
    return date;
  }

  /**
   * Generate output files to output directory. If the output directory has not existed yet,
   * produce the directory before generate the file.
   * @param result String list to be converted into txt file.
   */
  private void generateOutput(List<String> result) {
    String fileName = "email" + (emailNum < 10 ? 0 : "") + (emailNum++) + ".txt";
    File directory = new File(outputDir);
    if (!directory.exists()){
      directory.mkdirs();
    }
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputDir + fileName))) {
      for (int i = 0; i < result.size(); i++) {
        bw.write(result.get(i));
        bw.newLine();
      }
      System.out.println(fileName + "Done");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
