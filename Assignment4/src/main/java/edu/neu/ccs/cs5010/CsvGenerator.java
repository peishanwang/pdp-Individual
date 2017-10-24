package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * CsvGenerator is used to generate csv file.
 */
public class CsvGenerator implements ICsvGenerator {
  private static final String SEPARATOR = ", ";
  private static final String FILENAME = "DreamTraversal";
  private static final String FILETYPE = ".csv";
  private List<String> text;
  private String[] headers;

  /**
   * Constructor of CsvGenerator.
   * @param headers String array of output file headers
   */
  public CsvGenerator(String[] headers) {
    this.headers = headers.clone();
    text = new ArrayList<>();
    setHeader();
  }

  @Override
  public void addLine(HashMap<String, String> map) {
    StringBuilder strb = new StringBuilder();
    for (int i = 0; i < headers.length; i++) {
      if (i != 0) {
        strb.append(SEPARATOR);
      }
      strb.append(map.get(headers[i]));
    }
    text.add(strb.toString());
  }

  @Override
  public void generateCsv(String path, String encoding, String index) {
    IIoUtil ioUtil = new IoUtil(path, encoding);
    ioUtil.generateOutput(text, FILENAME + index + FILETYPE);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof CsvGenerator)) {
      return false;
    }
    CsvGenerator other = (CsvGenerator) object;
    boolean result = Arrays.equals(this.headers, other.headers)
        && (this.text.equals(other.text));
    return result;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + Arrays.hashCode(headers);
    result = 31 * result + text.hashCode();
    return result;
  }

  /**
   * Append headers information to new csv file.
   */
  private void setHeader() {
    StringBuilder strb = new StringBuilder();
    for (int i = 0; i < headers.length; i++) {
      if (i != 0) {
        strb.append(SEPARATOR);
      }
      strb.append(headers[i]);
    }
    text.add(strb.toString());
  }
}
