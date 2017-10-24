package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;

/**
 * CsvParser is used to parse cvs file's text.
 * It can read text and extract information between double quote.
 */
public class CsvParser implements ICsvParser {
  private List<List<String>> info;

  /**
   * Constructor of CsvParser.
   * @param path path of csv file.
   * @param encoding encoding while reading input stream
   */
  public CsvParser(String path, String encoding) {
    info = new ArrayList<>();
    IIoUtil ioUtil = new IoUtil(path, encoding);
    generateInfo(ioUtil.getInput());
  }

  /**
   * Using regular expression to extract information between double quote.
   * @param input a list of String contains text from csv file.
   */
  private void generateInfo(List<String> input) {
    String line;
    for (int i = 0; i < input.size(); i++) {
      line = input.get(i);
      String[] strings = line.split(",");
      List<String> currLine = new ArrayList<>();
      for (String str : strings) {
        currLine.add(str);
      }
      info.add(currLine);
    }
  }

  @Override
  public List<List<String>> getCsvInfo() {
    return info;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof CsvParser)) {
      return false;
    }
    CsvParser other = (CsvParser) object;
    return this.info.equals(other.info);
  }

  @Override
  public int hashCode() {
    int result = 17;
    for (List<String> list : info) {
      result = 31 * result + list.hashCode();
    }
    return result;
  }

}
