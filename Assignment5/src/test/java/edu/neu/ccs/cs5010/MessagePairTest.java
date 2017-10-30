package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

public class MessagePairTest {
  private IMessagePair messagePair1;
  private IMessagePair messagePair2;
  private IMessagePair messagePair3;

  @Before
  public void before() {
    IClient client = new Client(10, 10, 10,
        new ArrayList<>(), new ArrayList<>());
    messagePair1 = new MessagePair(10, client,
        BigInteger.valueOf(1), BigInteger.valueOf(2));
    messagePair2 = new MessagePair(10, client,
        BigInteger.valueOf(1), BigInteger.valueOf(2));
    messagePair3 = new MessagePair(99, client,
        BigInteger.valueOf(1), BigInteger.valueOf(2));
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(messagePair1.hashCode(), messagePair2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        messagePair2.hashCode() == messagePair3.hashCode());
  }

  @Test
  public void testEqualsNull() {
    Assert.assertEquals(false, messagePair1.equals(null));
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, messagePair1.equals(messagePair2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, messagePair2.equals(messagePair3));
  }

  @Test
  public void testEqualsSame() {
    IMessagePair messagePair4 = messagePair1;
    Assert.assertEquals(true, messagePair1.equals(messagePair4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    ITransactionVerification tst = new TransactionVerification();
    Assert.assertEquals(false, messagePair1.equals(tst));
  }
}
