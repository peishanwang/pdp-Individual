package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CSVParser is used to parse cvs file's text.
 * It can read text and extract information between double quote.
 */
public class CSVParser implements ICSVParser{
  private List<List<String>> info;

  /**
   * Constructor of CSVParser.
   * @param input a list of String contains text from csv file.
   */
  public CSVParser(List<String> input) {
    info = new ArrayList<>();
    generateInfo(input);
  }

  /**
   * Using regular expression to extract information between double quote.
   * @param input a list of String contains text from csv file.
   */
  private void generateInfo(List<String> input) {
    String line;
    for (int i = 0; i < input.size(); i++) {
      line = input.get(i);
      Pattern pa = Pattern.compile("\"(.*?)\"");
      Matcher ma = pa.matcher(line);
      List<String> currLine = new ArrayList<>();
      while (ma.find()) {
        currLine.add(ma.group(1));
      }
      info.add(currLine);
    }
  }

  /**
   * {@inheritDoc}
   */
  public List<List<String>> getCSVInfo() {
    return info;
  }

}
