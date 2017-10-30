package edu.neu.ccs.cs5010;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * This class is the simulator of a secure bank verification system.
 */
public class SecureBankVerificationSimulator implements ISecureBankVerificationSimulator{

  private static final int DEPOSIT_UPPERBOUND = 2000;
  private static final int WITHDRAWAL_UPPERBOUND = 3000;
  private static final String ENCODING = "UTF-8";
  private static final String TRANSACTION_NUMBER = "Transaction number";
  private static final String DATE = "Date";
  private static final String TIME = "Time";
  private static final String CLIENT_ID = "Client ID";
  private static final String MESSAGE = "Message";
  private static final String DIGITAL_SIGNATURE = "Digital signature";
  private static final String VERIFIED = "Verified";
  private static final String TRANSACTION_STATUS = "Transaction status";
  private static final String YES = "yes";
  private static final String NO_NO = "no";
  private static final String NOT_APPLICABLE = "N/A";
  private static final String DEPOSIT_REJECTED = "deposit rejected";
  private static final String WITHDRAWAL_REJECTED = "withdrawal rejected";
  private int totalClients;
  private int uniqueVerifications;
  private double invalidFraction;
  private String outputFile;

  /**
   * Constructor of SecureBankVerificationSimulator.
   * @param totalClients number of clients.
   * @param uniqueVerifications number of unique verifications.
   * @param invalidFraction invalid verification fraction.
   * @param outputFile output file name.
   */
  public SecureBankVerificationSimulator(int totalClients,
                                         int uniqueVerifications,
                                         double invalidFraction,
                                         String outputFile) {
    this.totalClients = totalClients;
    this.uniqueVerifications = uniqueVerifications;
    this.invalidFraction = invalidFraction;
    this.outputFile = outputFile;
  }

  /**
   * Main method.
   * @param strs input arguments.
   */
  public static void main(String[] strs) {
    IInputHandler input = new InputHandler(strs);
    ISecureBankVerificationSimulator simulator = new SecureBankVerificationSimulator(
        input.getTotalClients(),
        input.getUniqueVerifications(),
        input.getInvalidFraction(),
        input.getOuputFile());
    simulator.runSimulation();
  }

  @Override
  public void runSimulation() {
    IClientGenerator clients = new ClientGenerator(
        totalClients, DEPOSIT_UPPERBOUND, WITHDRAWAL_UPPERBOUND);
    IMessagePairGenerator pairGenerator = new MessagePairGenerator(
        uniqueVerifications, clients.getAllClients(), invalidFraction);
    List<HashMap<String, String>> allInfo = new ArrayList<>();
    HashSet<String> rejDepositIds = new HashSet<>();
    HashSet<String> rejWithdrawalIds = new HashSet<>();
    for (IMessagePair messagePair : pairGenerator.getAllMessagePairs()) {
      HashMap<String, String> transactionInfo = generateInfo(messagePair,
          rejDepositIds, rejWithdrawalIds);
      allInfo.add(transactionInfo);
    }
    generateOutput(allInfo);
    printConsole(clients, pairGenerator, rejDepositIds, rejWithdrawalIds);
  }

  /**
   * Generate output csv file.
   * @param info output file text information.
   */
  private void generateOutput(List<HashMap<String, String>> info) {
    List<String> headers = Arrays.asList(TRANSACTION_NUMBER, DATE, TIME, CLIENT_ID,
        MESSAGE, DIGITAL_SIGNATURE, VERIFIED, TRANSACTION_STATUS);
    ICsvGenerator output = new CsvGenerator(headers);
    for (HashMap<String, String> lineInfo : info) {
      output.addLine(lineInfo);
    }
    output.generateCsv(outputFile, ENCODING);
  }

  /**
   * Collect information for each message pair.
   * @param messagePair message pair to be analysed.
   * @param rejDepositIds list of client ids who have rejected deposit transactions.
   * @param rejWithdrawalIds list of client ids who have rejected withdrawal transactions.
   * @return a HashMap containing information.
   */
  private HashMap<String, String> generateInfo(IMessagePair messagePair,
                                               HashSet<String> rejDepositIds,
                                               HashSet<String> rejWithdrawalIds) {
    IRsaVerification rsaVerification = new RsaVerification();
    IClient client = messagePair.getClient();
    ITransactionVerification tstVerification = new TransactionVerification();
    HashMap<String, String> transactionInfo = new HashMap<>();
    transactionInfo.put(TRANSACTION_NUMBER, messagePair.getTransactionId());
    transactionInfo.put(DATE, getDate());
    transactionInfo.put(TIME, getTime());
    transactionInfo.put(CLIENT_ID, client.getClientId());
    transactionInfo.put(MESSAGE, messagePair.getMessage().toString());
    transactionInfo.put(DIGITAL_SIGNATURE, messagePair.getDigitalSignature().toString());
    boolean verified = rsaVerification.verifyMessage(messagePair.getDigitalSignature(),
        ((Client)client).getPublicKey(), messagePair.getMessage());
    transactionInfo.put(VERIFIED, verified ? YES : NO_NO);
    if (verified) {
      String tstResult = tstVerification.verifyTransaction(
          messagePair.getMessage(), client);
      if (tstResult.equals(WITHDRAWAL_REJECTED)) {
        rejWithdrawalIds.add(client.getClientId());
      } else if (tstResult.equals(DEPOSIT_REJECTED)) {
        rejDepositIds.add(client.getClientId());
      }
      transactionInfo.put(TRANSACTION_STATUS, tstResult);
    } else {
      transactionInfo.put(TRANSACTION_STATUS, NOT_APPLICABLE);
    }
    return transactionInfo;
  }

  /**
   * Print information in console.
   * @param clients client generator.
   * @param pairGenerator message pair generator.
   * @param rejDepositIds list of client ids who have rejected deposit transactions.
   * @param rejWithdrawalIds list of client ids who have rejected withdrawal transactions.
   */
  private void printConsole(IClientGenerator clients,
                            IMessagePairGenerator pairGenerator,
                            HashSet<String> rejDepositIds,
                            HashSet<String> rejWithdrawalIds) {
    IPrinter printer = new Printer(clients.getAllClients(), pairGenerator.getAllMessagePairs(),
        new ArrayList<>(rejDepositIds), new ArrayList<>(rejWithdrawalIds));
    printer.print();
  }

  /**
   * Returns current date information in specific format.
   * @return current date information in specific format.
   */
  private String getDate() {
    return new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
  }

  /**
   * Returns current time information in specific format.
   * @return current time information in specific format.
   */
  private String getTime() {
    return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
  }
}
