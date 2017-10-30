package edu.neu.ccs.cs5010;

import org.junit.Test;

public class SimulatorTest {

  @Test
  public void testMain() {
    String[] input = new String[] {
        "100", "100", "0.2", "src\\test\\output\\bankSimulatorResult.csv"
    };
    SecureBankVerificationSimulator.main(input);
  }
}
