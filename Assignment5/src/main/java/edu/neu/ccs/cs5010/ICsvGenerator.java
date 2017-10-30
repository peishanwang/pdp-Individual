package edu.neu.ccs.cs5010;

import java.util.HashMap;

/**
 * ICsvGenerator contains methods to generate new csv file.
 */
public interface ICsvGenerator {
  /**
   * Add one line to csv file text.
   * @param map information to be added.
   */
  void addLine(HashMap<String, String> map);

  /**
   * Generate new csv file.
   * @param path output file path
   * @param encoding encoding type
   */
  void generateCsv(String path, String encoding);
}
