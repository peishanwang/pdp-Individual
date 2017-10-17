package edu.neu.ccs.cs5010;

import java.util.Random;

/**
 * RandomERSimulator is used to generate in random mode.
 */
public class RandomERSimulator extends ERSimulator{
  private final static int SHORTEST_RANDOMGAP = 1;
  private final static int LONGEST_RANDOMGAP = 20;

  /**
   * Constructor of RandomERSimulator
   * @param parameters input information
   */
  public RandomERSimulator(IInputScanner parameters) {
    super(parameters);
    patientGenerator = new RandomGenerator();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void sleep() {
    Random random = new Random();
    int gapMinutes = SHORTEST_RANDOMGAP + random.nextInt(LONGEST_RANDOMGAP - SHORTEST_RANDOMGAP + 1);
    try {
      Thread.sleep(gapMinutes * 1000);
    } catch (InterruptedException e) {
      System.out.println("got interrupted!");
    }
  }
}
