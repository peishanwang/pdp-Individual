package edu.neu.ccs.cs5010;

public interface IInputHandler {
  /**
   * Returns number of total clients.
   * @return number of total clients.
   */
  int getTotalClients();

  /**
   * Returns number of unique verifications.
   * @return number of unique verifications.
   */
  int getUniqueVerifications();

  /**
   * Returns invalid message fraction.
   * @return invalid message fraction.
   */
  double getInvalidFraction();

  /**
   * Returns output file name.
   * @return output file name.
   */
  String getOuputFile();
}
