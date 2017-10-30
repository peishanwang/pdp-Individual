package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * ClientGenerator is used to generate clients.
 */
public class ClientGenerator implements IClientGenerator {
  private static final int BIT_LENGTH = 256;
  private int totalClients;
  private int depositUpperbound;
  private int withdrawalUpperbound;
  private List<IClient> allClients;
  private Random rnd;
  private HashMap<Integer, Integer> idToIndex;

  /**
   * Constructor of ClientGenerator.
   * @param totalClients number of clients to be generated.
   * @param depositUpperbound deposit limit upper bound.
   * @param withdrawalUpperbound withdrawal limit upper bound.
   */
  public ClientGenerator(int totalClients, int depositUpperbound, int withdrawalUpperbound) {
    this.totalClients = totalClients;
    this.depositUpperbound = depositUpperbound;
    this.withdrawalUpperbound = withdrawalUpperbound;
    idToIndex = new HashMap<>();
    allClients = new ArrayList<>();
    rnd = new Random();
    generateClients();
  }

  /**
   * Generate clients.
   */
  private void generateClients() {
    for (int i = 0; i < totalClients; i++) {
      IKeyGenerator keyGenerator = new KeyGenerator(BIT_LENGTH);
      int randomId;
      do {
        randomId = rnd.nextInt(Integer.MAX_VALUE);
      } while (idToIndex.containsKey(randomId));
      allClients.add(new Client(randomId, rnd.nextInt(depositUpperbound),
          rnd.nextInt(withdrawalUpperbound), keyGenerator.getPrivateKey(),
          keyGenerator.getPublicKey()));
      System.out.println("A client created!");
    }
  }

  @Override
  public List<IClient> getAllClients() {
    return allClients;
  }
}
