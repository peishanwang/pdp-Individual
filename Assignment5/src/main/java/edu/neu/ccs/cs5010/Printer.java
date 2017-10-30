package edu.neu.ccs.cs5010;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Printer is used to print result to console.
 */
public class Printer implements IPrinter {
  private List<IClient> allClients;
  private List<IMessagePair> messagePairs;
  private List<String> rejDepositIds;
  private List<String> rejWithdrawalIds;

  /**
   * Constructor of Printer.
   * @param allClients list of all clients.
   * @param messagePairs list of all message pairs.
   * @param rejDepositIds list of client ids who have rejected deposit.
   * @param rejWithdrawalIds list of client ids who have rejected withdrawal.
   */
  public Printer(List<IClient> allClients,
                 List<IMessagePair> messagePairs,
                 List<String> rejDepositIds,
                 List<String> rejWithdrawalIds) {
    this.allClients = allClients;
    this.messagePairs = messagePairs;
    this.rejDepositIds = rejDepositIds;
    this.rejWithdrawalIds = rejWithdrawalIds;
  }

  @Override
  public void print() {
    System.out.println("1.The number of distinct transactions with different IDs, "
        + "but the same public key");
    checkRepeated();
    System.out.println("2.Top ten unique users with the largest number of transactions");
    printTopTenUsers();
    System.out.println("3.List of all IDs with rejected deposit transactions");
    printList(rejDepositIds);
    System.out.println("4.List of all IDs with rejected withdrawal transactions");
    printList(rejWithdrawalIds);

  }

  /**
   * Checked whether there are transactions with different client ids but same public key.
   */
  private void checkRepeated() {
    int count = 0;
    HashMap<String, Integer> idToTimes = new HashMap<>();
    HashMap<List<BigInteger>, List<String>> pkToId = new HashMap<>();
    for (IMessagePair messagePair : messagePairs) {
      IClient currClient = messagePair.getClient();
      idToTimes.put(currClient.getClientId(),
          idToTimes.getOrDefault(currClient.getClientId(), 0));
      pkToId.getOrDefault(currClient.getPublicKey(),
          new ArrayList<>()).add(currClient.getClientId());
    }
    for (List<String> ids : pkToId.values()) {
      if (ids.size() > 1) {
        System.out.println("These clients have the same public key: ");
        for (int i = 0; i < ids.size(); i++) {
          System.out.print(ids.get(i));
          if (i != ids.size() - 1) {
            System.out.print(", ");
          }
        }
        System.out.println();
        for (String id : ids) {
          System.out.print(id + ": " + idToTimes.get(id) + "times");
          count += idToTimes.get(id);
        }
      }
    }
    System.out.println("Total number of conflicts: " + count);
  }

  /**
   * Print clients' id who has the top ten most number of transactions.
   * If clients have same transaction times, we will choose the client with smaller
   * id number first.
   */
  private void printTopTenUsers() {
    Collections.sort(allClients);
    for (int i = 0; i < 10; i++) {
      System.out.println((i + 1) + ": " + allClients.get(i).getClientId());
      System.out.println("\ttotal transactionTimes: " + allClients.get(i).getTransactionTimes());
    }
  }

  /**
   * Print a list of string.
   * @param list list of string.
   */
  private void printList(List<String> list) {
    for (String str : list) {
      System.out.println("\t" + str);
    }
  }
}
