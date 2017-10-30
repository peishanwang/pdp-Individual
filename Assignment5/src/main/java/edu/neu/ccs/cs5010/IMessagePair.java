package edu.neu.ccs.cs5010;

import java.math.BigInteger;

/**
 * Interface of MessagePair.
 *
 * @see MessagePair
 */
public interface IMessagePair {
  /**
   * Returns corresponding client.
   * @return corresponding client.
   */
  IClient getClient();

  /**
   * Returns message information.
   * @return message information.
   */
  BigInteger getMessage();

  /**
   * Returns digital signature.
   * @return digital signature.
   */
  BigInteger getDigitalSignature();

  /**
   * Returns transaction id.
   * @return transaction id.
   */
  String getTransactionId();
}
