package edu.neu.ccs.cs5010;

import java.math.BigInteger;

/**
 * TransactionVerification is to verify if a transaction for a client can be approved.
 */
public class TransactionVerification implements ITransactionVerification {
  private static final int ACTION_SEPARATOR = 5;
  private static final String DEPOSIT_ACCEPTED = "deposit accepted";
  private static final String DEPOSIT_REJECTED = "deposit rejected";
  private static final String WITHDRAWAL_ACCEPTED = "withdrawal accepted";
  private static final String WITHDRAWAL_REJECTED = "withdrawal rejected";

  @Override
  public String verifyTransaction(BigInteger message, IClient client) {
    String msg = message.toString();
    int action = Integer.parseInt(msg.substring(msg.length() - 1));
    int amout = Integer.parseInt(msg.substring(0, msg.length() - 1));
    if (action < ACTION_SEPARATOR) {
      if (amout <= client.getDepositLimit()) {
        return DEPOSIT_ACCEPTED;
      } else {
        return DEPOSIT_REJECTED;
      }
    } else {
      if (amout <= client.getWithdrawalLimit()) {
        return WITHDRAWAL_ACCEPTED;
      }
      return WITHDRAWAL_REJECTED;
    }
  }
}
