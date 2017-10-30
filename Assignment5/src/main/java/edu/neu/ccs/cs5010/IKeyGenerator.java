package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.List;

/**
 * Interface of KeyGenerator containing methods to get keys.
 *
 * @see KeyGenerator
 */
public interface IKeyGenerator {
  /**
   * Returns private key.
   * @return private key.
   */
  List<BigInteger> getPrivateKey();

  /**
   * Returns public key.
   * @return public key.
   */
  List<BigInteger> getPublicKey();
}
