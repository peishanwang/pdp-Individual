package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputScannerTest {



  @Test
  public void testInputReminder() {
    String input = "prese\npreset\n-1\n2\n-1\n1\n-1\n5\n-1\n15\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    IInputScanner inputScanner = new InputScanner();
  }

}

