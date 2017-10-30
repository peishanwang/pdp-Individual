package edu.neu.ccs.cs5010;

/**
 * InputHandler is used to handle command line input.
 */
public class InputHandler implements IInputHandler {
  private static final int MAX_CLIENTS = 50000;
  private static final int MAX_PAIRS = 10000;
  private static final int MIN_FRACTION = 0;
  private static final int MAX_FRACTION = 1;
  private int totalClients;
  private int uniqueVerifications;
  private double invalidFraction;
  private String outputFile;

  /**
   * Constructor of InputHandler.
   * @param args input arguments.
   */
  public InputHandler(String[] args) {
    if (args.length != 4) {
      throw new IllegalArgumentException("You need to provide four input arguments.");
    }
    totalClients = Integer.parseInt(args[0]);
    if (totalClients > MAX_CLIENTS) {
      throw new IllegalArgumentException("Number of clients is bounded from above by "
          + MAX_CLIENTS);
    }
    uniqueVerifications = Integer.parseInt(args[1]);
    if (uniqueVerifications > MAX_PAIRS) {
      throw new IllegalArgumentException("Number of message pairs is bounded from above by "
          + MAX_PAIRS);
    }
    invalidFraction = Double.valueOf(args[2]);
    if (invalidFraction < MIN_FRACTION || invalidFraction > MAX_FRACTION) {
      throw new IllegalArgumentException("Fraction should be between 0 to 1");
    }
    outputFile = args[3];
  }

  @Override
  public int getTotalClients() {
    return totalClients;
  }

  @Override
  public int getUniqueVerifications() {
    return uniqueVerifications;
  }

  @Override
  public double getInvalidFraction() {
    return invalidFraction;
  }

  @Override
  public String getOuputFile() {
    return outputFile;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(this.getClass().isInstance(object))) {
      return false;
    }
    InputHandler other = (InputHandler) object;
    boolean result = this.totalClients == other.totalClients
        && this.uniqueVerifications == other.uniqueVerifications
        && this.invalidFraction == other.invalidFraction
        && this.outputFile.equals(other.outputFile);
    return result;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + totalClients;
    result = 31 * result + uniqueVerifications;
    result = 31 * result + new Double(invalidFraction).hashCode();
    result = 31 * result + outputFile.hashCode();
    return result;
  }


}
