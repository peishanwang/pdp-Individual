package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IoUtilTest {
  private IIoUtil ioUtil1;
  private IIoUtil ioUtil2;
  private IIoUtil ioUtil3;

  @Before
  public void before() {
    ioUtil1 = new IoUtil("src\\main\\resources\\DreamCandy1.csv",
        "UTF-8");
    ioUtil2 = new IoUtil("src\\main\\resources\\DreamCandy1.csv",
        "UTF-8");
    ioUtil3 = new IoUtil("src\\main\\resources\\DreamCandy5.csv",
        "UTF-8");
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(ioUtil1.hashCode(), ioUtil2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        ioUtil2.hashCode() == ioUtil3.hashCode());
  }

  @Test
  public void testEqualsNull() {
    Assert.assertEquals(false, ioUtil1.equals(null));
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, ioUtil1.equals(ioUtil2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, ioUtil2.equals(ioUtil3));
  }

  @Test
  public void testEqualsSame() {
    IIoUtil ioUtil4 = ioUtil1;
    Assert.assertEquals(true, ioUtil1.equals(ioUtil4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    ITransactionVerification tst = new TransactionVerification();
    Assert.assertEquals(false, ioUtil1.equals(tst));
  }
}
