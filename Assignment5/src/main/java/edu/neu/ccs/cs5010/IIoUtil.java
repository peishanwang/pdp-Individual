package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * IIoUtil interface provide methods getInput and generateOutput.
 * getInput is used to read text from file.
 * generateOutput is used to output file to specific directory.
 *
 * @see IoUtil
 */
public interface IIoUtil {
  /**
   * Output file to specific directory.
   * @param result text to be output
   * @param fileName name of the output file
   */
  void generateOutput(List<String> result, String fileName);
}
