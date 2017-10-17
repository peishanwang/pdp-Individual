package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * ICSVParser contains method getCSVInfo. It can be used parse CSV file.
 *
 * @see CSVParser
 */
public interface ICSVParser {
  /**
   * Returns information parsed from csv file.
   * @return information parsed from csv file.
   */
  List<List<String>> getCSVInfo();
}
