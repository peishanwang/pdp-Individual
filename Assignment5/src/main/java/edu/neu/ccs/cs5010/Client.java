package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.List;

/**
 * Class of client containing each client's information. Information include
 * client id, private key, public key, deposit limit, withdrawal limit.
 * This class also memorize the transaction times for each client.
 */
public class Client implements IClient<Client> {
  private static final int PRIVATE_A = 0;
  private static final int PRIVATE_N = 1;
  private List<BigInteger> privateKey;
  private List<BigInteger> publicKey;
  private int clientId;
  private int depositLimit;
  private int withdrawalLimit;
  private int numOfTransaction;

  @Override
  public int compareTo(Client other) {
    if (other == null) {
      throw new IllegalArgumentException("Can not compare object with null.");
    }
    if (this.numOfTransaction > other.numOfTransaction) {
      return -1;
    } else if (this.numOfTransaction < other.numOfTransaction) {
      return 1;
    } else {
      if (this.clientId < other.clientId) {
        return -1;
      } else if (this.clientId > other.clientId) {
        return 1;
      }
    }
    return 0;
  }

  /**
   * Constructor of client.
   * @param clientId client id.
   * @param depositLimit deposit limit.
   * @param withdrawalLimit withdrawal limit.
   * @param privateKey private key.
   * @param publicKey public key.
   */
  public Client(int clientId, int depositLimit, int withdrawalLimit,
                List<BigInteger> privateKey, List<BigInteger> publicKey) {
    this.clientId = clientId;
    this.depositLimit = depositLimit;
    this.withdrawalLimit = withdrawalLimit;
    this.privateKey = privateKey;
    this.publicKey = publicKey;
    numOfTransaction = 0;
  }

  @Override
  public BigInteger getSignature(BigInteger message) {
    BigInteger keyA = privateKey.get(PRIVATE_A);
    BigInteger keyN = privateKey.get(PRIVATE_N);
    BigInteger sigma = message.modPow(keyA, keyN);
    return sigma;
  }

  @Override
  public List<BigInteger> getPublicKey() {
    return publicKey;
  }

  @Override
  public String getClientId() {
    return String.format("%010d", clientId);
  }

  @Override
  public int getDepositLimit() {
    return depositLimit;
  }

  @Override
  public int getWithdrawalLimit() {
    return withdrawalLimit;
  }

  @Override
  public void addTransaction() {
    numOfTransaction++;
  }

  @Override
  public int getTransactionTimes() {
    return numOfTransaction;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(this.getClass().isInstance(object))) {
      return false;
    }
    Client other = (Client) object;
    return this.clientId == other.clientId;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + clientId;
    return result;
  }
}
