package edu.neu.ccs.cs5010;

/**
 * Evaluator contains method to find the replacement information corresponding to placeholder.
 */
public interface Evaluator {
  /**
   * Find the value corresponding to the placeholder.
   * @param placeholder
   * @return a string which is the replacement of this placeholder.
   */
  String getValue(String placeholder);

}
