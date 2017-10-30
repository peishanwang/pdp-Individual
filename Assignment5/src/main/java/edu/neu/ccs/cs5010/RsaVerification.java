package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.List;

/**
 * RsaVerification is used to verify message using public key.
 */
public class RsaVerification implements IRsaVerification{
  private static final int PUBLIC_B = 0;
  private static final int PUBLIC_N = 1;

  @Override
  public boolean verifyMessage(BigInteger signature,
                               List<BigInteger> publicKey,
                               BigInteger message) {
    BigInteger keyB = publicKey.get(PUBLIC_B);
    BigInteger keyN = publicKey.get(PUBLIC_N);
    if (message.equals(signature.modPow(keyB, keyN))) {
      System.out.println("Message approved!");
      return true;
    }
    System.out.println("Message invalid!");
    return false;
  }
}
