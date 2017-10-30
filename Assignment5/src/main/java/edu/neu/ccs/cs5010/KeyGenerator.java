package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * KeyGenerator is used to generate key pairs.
 */
public class KeyGenerator implements IKeyGenerator{
  private Random rnd;
  private BigInteger keyN;
  private BigInteger keyA;
  private BigInteger keyB;
  private int bitLength;

  /**
   * Constructor of KeyGenerator.
   * @param bitLength bitLength of the randomly generated prime number.
   */
  public KeyGenerator(int bitLength) {
    this.bitLength = bitLength;
    rnd = new SecureRandom();
    generateKeys();
  }

  /**
   * Generate a key pair.
   */
  private void generateKeys() {
    BigInteger primeP = BigInteger.probablePrime(bitLength, rnd);
    BigInteger primeQ = BigInteger.probablePrime(bitLength, rnd);
    BigInteger phi = primeP.subtract(BigInteger.ONE).multiply(primeQ.subtract(BigInteger.ONE));
    keyN = primeP.multiply(primeQ);
    do {
      keyA = BigInteger.probablePrime(bitLength, rnd);
    } while (!keyN.gcd(keyA).equals(BigInteger.ONE) || !phi.gcd(keyA).equals(BigInteger.ONE));
    keyB = keyA.modInverse(phi);
  }

  @Override
  public List<BigInteger> getPrivateKey() {
    List<BigInteger> privateKey = new ArrayList<>();
    privateKey.add(keyA);
    privateKey.add(keyN);
    return privateKey;
  }

  @Override
  public List<BigInteger> getPublicKey() {
    List<BigInteger> publicKey = new ArrayList<>();
    publicKey.add(keyB);
    publicKey.add(keyN);
    return publicKey;
  }

}
