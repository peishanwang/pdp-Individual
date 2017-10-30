package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.List;

public interface IClient<T> extends Comparable<T> {
  /**
   * Returns corresponding signature of input message.
   * @param message input message.
   * @return corresponding signature of input message.
   */
  BigInteger getSignature(BigInteger message);

  /**
   * Returns public key of the client.
   * @return public key of the client.
   */
  List<BigInteger> getPublicKey();

  /**
   * Returns id of the client.
   * @return id of the client.
   */
  String getClientId();

  /**
   * Returns deposit limit of the client.
   * @return deposit limit of the client.
   */
  int getDepositLimit();

  /**
   * Returns withdrawal limit of the client.
   * @return withdrawal limit of the client.
   */
  int getWithdrawalLimit();

  /**
   * Add one time of transaction to the client.
   */
  void addTransaction();

  /**
   * Returns times of transaction of the client.
   * @return times of transaction of the client.
   */
  int getTransactionTimes();

}
