package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * MessagePairGenerator is used to generate message pairs.
 */
public class MessagePairGenerator implements IMessagePairGenerator{
  private static final int MESSAGE_MIN = 10;
  private static final int MESSAGE_MAX = 30000;
  private static final int MAX_RANDOM_SIGNATURE = 60000;
  private static final int COIN_COEFFICIENT = 100;
  private int totalMessagePair;
  private List<IMessagePair> allMessagePairs;
  private List<IClient> allClient;
  private Random rnd;
  private double invalidFraction;

  /**
   * Constructor of MessagePairGenerator.
   * @param totalMessagePair number of message pairs
   * @param allClient list of all clients
   * @param fraction invalid verification fraction
   */
  public MessagePairGenerator(int totalMessagePair, List<IClient> allClient, double fraction) {
    this.totalMessagePair = totalMessagePair;
    this.allClient = allClient;
    this.invalidFraction = fraction;
    rnd = new Random();
    allMessagePairs = new ArrayList<>();
    generateMessagePair();
  }

  /**
   * Generate message pair.
   */
  private void generateMessagePair() {
    for (int i = 0; i < totalMessagePair; i++) {
      IClient client = allClient.get(rnd.nextInt(allClient.size()));
      client.addTransaction();
      BigInteger message = BigInteger.valueOf((long) MESSAGE_MIN + 1
          + rnd.nextInt(MESSAGE_MAX - MESSAGE_MIN));
      BigInteger signature;
      int coin = rnd.nextInt(COIN_COEFFICIENT);
      if (coin < invalidFraction * COIN_COEFFICIENT) {
        signature = BigInteger.valueOf(rnd.nextInt(MAX_RANDOM_SIGNATURE));
      } else {
        signature = client.getSignature(message);
      }
      allMessagePairs.add(new MessagePair(i, client, message, signature));
      System.out.println("A message pair created");
    }
  }

  @Override
  public List<IMessagePair> getAllMessagePairs() {
    return allMessagePairs;
  }
}
