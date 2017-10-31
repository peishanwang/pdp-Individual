package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class PrinterTest {
  IPrinter printer;

  @Before
  public void before() {
    IClient client1 = new Client(1, 10, 10,
        new ArrayList<>(), Arrays.asList(BigInteger.valueOf(4), BigInteger.valueOf(4)));
    IClient client2 = new Client(2, 10, 10,
        new ArrayList<>(), Arrays.asList(BigInteger.valueOf(2), BigInteger.valueOf(2)));
    IClient client3 = new Client(3, 10, 10,
        new ArrayList<>(), Arrays.asList(BigInteger.valueOf(3), BigInteger.valueOf(3)));
    IClient client4 = new Client(4, 10, 10,
        new ArrayList<>(), Arrays.asList(BigInteger.valueOf(4), BigInteger.valueOf(4)));
    IMessagePair messagePair1 = new MessagePair(1, client1,
        BigInteger.valueOf(1), BigInteger.valueOf(2));
    IMessagePair messagePair2 = new MessagePair(2, client4,
        BigInteger.valueOf(1), BigInteger.valueOf(2));
    IMessagePair messagePair3 = new MessagePair(3, client4,
        BigInteger.valueOf(1), BigInteger.valueOf(2));
    printer = new Printer(Arrays.asList(client1, client2, client3, client4),
        Arrays.asList(messagePair1, messagePair2, messagePair3),
        Arrays.asList("1", "2", "3"),
        Arrays.asList("1", "2", "3"));
  }

  @Test
  public void testRepeated() {
    printer.print();
  }

}
