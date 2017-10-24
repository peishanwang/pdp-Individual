package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * ICsvParser contains method getCsvInfo. It can be used parse CSV file.
 *
 * @see CsvParser
 */
public interface ICsvParser {
  /**
   * Returns information parsed from csv file.
   * @return information parsed from csv file.
   */
  List<List<String>> getCsvInfo();
}
