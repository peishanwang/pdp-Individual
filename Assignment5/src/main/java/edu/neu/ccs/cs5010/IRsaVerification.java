package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.List;

/**
 * Interface of RsaVerification containing method to verify message.
 *
 * @see RsaVerification
 */
public interface IRsaVerification {
  /**
   * Verify message.
   * @param signature message signature.
   * @param publicKey public key.
   * @param message message information.
   * @return True if verified successfully. False otherwise.
   */
  boolean verifyMessage(BigInteger signature, List<BigInteger> publicKey, BigInteger message);
}
