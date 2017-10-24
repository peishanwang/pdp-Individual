package edu.neu.ccs.cs5010;

/**
 * Exception to be thrown when cannot find a specific candy.
 */
public class CandyNotFoundException extends RuntimeException {

  /**
   * Generator of the exception.
   * @param str Exception message.
   */
  public CandyNotFoundException(String str) {
    super(str);
  }
}
