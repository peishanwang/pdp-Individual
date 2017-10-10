package edu.neu.ccs.cs5010;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CustomerData is used to generate customers' personal data from csv file.
 */
public class CustomerData implements ICustomerData{
  private HashMap<String, List<String>> data;
  private HashMap<String, Integer> headerToIndex;
  private BufferedReader br;
  private int size;

  /**
   * Constructor of CustomerData
   * @param path path of csv file of raw customer's data
   * @param items information type needed to extract from raw data
   */
  public CustomerData(String path, List<String> items) {
    data = new HashMap<>();
    size = 0;
    headerToIndex = new HashMap<>();
    data = new HashMap<>();
    String firstLine = "";
    try {
      br = new BufferedReader(new FileReader(path));
      firstLine = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    getHeaderIndex(firstLine, items);
    generateData();
  }

  /**
   * Get the headers of needed information and their corresponding column index
   * @param firstLine header's information
   * @param items information type needed to extract from raw data
   */
  private void getHeaderIndex(String firstLine, List<String> items) {
    Pattern p = Pattern.compile("\"(.*?)\"");
    Matcher m = p.matcher(firstLine);
    int col = 0, count = 0;
    while(m.find()){
      String curr = m.group(1);
      if (curr.equals(items.get(0))) {
        headerToIndex.put(curr, col);
        data.put(curr, new ArrayList<>());
        items.add(items.get(0));
        items.remove(0);
        count++;
      }
      col++;
    }
    if (count != items.size()) throw new NeededDataNotProvidedException();
  }

  /**
   * Generate data in specific format and store them in a HashMap. The keys are
   * names of headers, values are corresponding customer's information.
   */
  private void generateData() {
    String line;
    try {
      while ((line = br.readLine()) != null) {
        size++;
        Pattern pa = Pattern.compile("\"(.*?)\"");
        Matcher ma = pa.matcher(line);
        List<String> currLine = new ArrayList<>();
        while(ma.find()){
          currLine.add(ma.group(1));
        }
        for (String key : data.keySet()) {
          data.get(key).add(currLine.get(headerToIndex.get(key)));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HashMap<String, List<String>> getData() {
    return data;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getSize() {
    return size;
  }
}
