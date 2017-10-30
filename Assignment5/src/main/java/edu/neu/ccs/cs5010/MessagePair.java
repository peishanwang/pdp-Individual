package edu.neu.ccs.cs5010;

import java.math.BigInteger;

/**
 * MessagePair containing message, signature, transaction id and client.
 */
public class MessagePair implements IMessagePair{
  private IClient client;
  private BigInteger message;
  private BigInteger digitalSignature;
  private int transactionId;

  /**
   * Constructor of MessagePair.
   * @param transactionId transaction id.
   * @param client corresponding client.
   * @param message message information.
   * @param digitalSignature digital signature information.
   */
  public MessagePair(int transactionId, IClient client,
                     BigInteger message, BigInteger digitalSignature) {
    this.transactionId = transactionId;
    this.client = client;
    this.message = message;
    this.digitalSignature = digitalSignature;
  }

  @Override
  public IClient getClient() {
    return client;
  }

  @Override
  public BigInteger getMessage() {
    return message;
  }

  @Override
  public BigInteger getDigitalSignature() {
    return digitalSignature;
  }

  @Override
  public String getTransactionId() {
    return transactionId + "";
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(this.getClass().isInstance(object))) {
      return false;
    }
    MessagePair other = (MessagePair) object;
    return this.transactionId == other.transactionId;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + transactionId;
    return result;
  }
}
