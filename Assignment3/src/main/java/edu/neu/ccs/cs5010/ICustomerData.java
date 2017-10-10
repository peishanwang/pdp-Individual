package edu.neu.ccs.cs5010;

import java.util.HashMap;
import java.util.List;

/**
 * ICustomerData is used to generate customers' personal data from csv file.
 */
public interface ICustomerData {
  /**
   * Returns a HashMap which contains all email-needed data from csv file.
   * @return HashMap whose keys are data header, and values are lists
   * which contain all corresponding data of customers.
   */
  HashMap<String, List<String>> getData();

  /**
   * Returns the number of customers whose data are imported
   * @return number of customers
   */
  int getSize();
}
