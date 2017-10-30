package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ClientTest {
  private IClient client1;
  private IClient client2;
  private IClient client3;

  @Before
  public void before() {
    client1 = new Client(10, 10, 10,
        new ArrayList<>(), new ArrayList<>());
    client2 = new Client(10, 10, 10,
        new ArrayList<>(), new ArrayList<>());
    client3 = new Client(99, 10, 10,
        new ArrayList<>(), new ArrayList<>());
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(client1.hashCode(), client2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        client2.hashCode() == client3.hashCode());
  }

  @Test
  public void testEqualsNull() {
    Assert.assertEquals(false, client1.equals(null));
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, client1.equals(client2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, client2.equals(client3));
  }

  @Test
  public void testEqualsSame() {
    IClient client4 = client1;
    Assert.assertEquals(true, client1.equals(client4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    ITransactionVerification tst = new TransactionVerification();
    Assert.assertEquals(false, client1.equals(tst));
  }
}
