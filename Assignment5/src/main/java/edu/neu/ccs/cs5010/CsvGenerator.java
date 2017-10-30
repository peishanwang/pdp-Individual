package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * CsvGenerator is used to generate csv file.
 */
public class CsvGenerator implements ICsvGenerator {
  private static final String SEPARATOR = ", ";
  private List<String> text;
  private List<String> headers;

  /**
   * Constructor of CsvGenerator.
   * @param headers String array of output file headers
   */
  public CsvGenerator(List<String> headers) {
    this.headers = headers;
    text = new ArrayList<>();
    setHeader();
  }

  @Override
  public void addLine(HashMap<String, String> map) {
    StringBuilder strb = new StringBuilder();
    for (int i = 0; i < headers.size(); i++) {
      if (i != 0) {
        strb.append(SEPARATOR);
      }
      strb.append(map.get(headers.get(i)));
    }
    text.add(strb.toString());
  }

  @Override
  public void generateCsv(String pathAndName, String encoding) {
    String[] strs = pathAndName.split("\\\\");
    String filename = strs[strs.length - 1];
    String path = pathAndName.substring(0, pathAndName.length() - filename.length());
    IIoUtil ioUtil = new IoUtil(path, encoding);
    ioUtil.generateOutput(text, filename);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(this.getClass().isInstance(object))) {
      return false;
    }
    CsvGenerator other = (CsvGenerator) object;
    boolean result = this.headers.equals(other.headers)
        && (this.text.equals(other.text));
    return result;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + headers.hashCode();
    result = 31 * result + text.hashCode();
    return result;
  }

  /**
   * Append headers information to new csv file.
   */
  private void setHeader() {
    StringBuilder strb = new StringBuilder();
    for (int i = 0; i < headers.size(); i++) {
      if (i != 0) {
        strb.append(SEPARATOR);
      }
      strb.append(headers.get(i));
    }
    text.add(strb.toString());
  }
}
