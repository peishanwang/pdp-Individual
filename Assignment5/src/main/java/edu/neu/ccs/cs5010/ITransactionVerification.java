package edu.neu.ccs.cs5010;

import java.math.BigInteger;

/**
 * Interface of TransactionVerification with method to verify transaction.
 *
 * @see TransactionVerification
 */
public interface ITransactionVerification {
  /**
   * Verify the transaction and return the transaction status message.
   * @param message message to be verify.
   * @param client client corresponding to the message.
   * @return transaction status message.
   */
  String verifyTransaction(BigInteger message, IClient client);
}
