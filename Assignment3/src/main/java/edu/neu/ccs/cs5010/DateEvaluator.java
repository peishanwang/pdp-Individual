package edu.neu.ccs.cs5010;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateEvaluator is a subclass of KeyValueEvaluator.
 * It store the date information using key-value pair.
 *
 * @see KeyValueEvaluator
 */
public class DateEvaluator extends KeyValueEvaluator{
  private static final String DATE_PATTERN = "yyyy-MM-dd";

  /**
   * Constructor of DateEvaluator
   * @param key String key of the pair which store date information
   */
  public DateEvaluator(String key) {
    super(key, getCurrentDate());
  }

  /**
   * Returns current date in specific format
   * @return current date in specific format
   */
  private static String getCurrentDate() {
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
    Date now = new Date();
    String date = sdf.format(now);
    return date;
  }
}
