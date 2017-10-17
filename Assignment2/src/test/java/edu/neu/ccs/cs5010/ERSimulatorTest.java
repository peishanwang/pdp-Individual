package edu.neu.ccs.cs5010;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ERSimulatorTest {
  private IERSimulator simulator;

  @Test
  public void testPreset() {
    String input = "preset\n2\n1\n5\n15\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    ERSimulator.main(new String[1]);
  }

  @Test
  public void testRandom() {
    String input = "random\n2\n1\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    ERSimulator.main(new String[1]);
  }
}
