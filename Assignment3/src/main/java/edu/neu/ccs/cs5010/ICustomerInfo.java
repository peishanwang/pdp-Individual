package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * ICustomerInfo is the interface of CustomerInfo. It contains methods to
 * get headers, and to iterate customer's data using hasNextCustomer() and
 * nextCustomer().
 *
 * @see CustomerInfo
 */
public interface ICustomerInfo {
  /**
   * Returns header's of customers' information.
   * @return header's of customers' information.
   */
  List<String> getHeaders();

  /**
   * Checks whether current iterator has next customer's information.
   * @return True if haven't finished iterating. False otherwise.
   *
   */
  boolean hasNextCustomer();

  /**
   * Iterate next customer's information.
   * @return information of next customer.
   */
  List<String> nextCustomer();

}
