package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputHandlerTest {
  private IInputHandler handler;
  private IInputHandler handler1;
  private IInputHandler handler2;
  private IInputHandler handler3;

  @Before
  public void before() {
    String[] input1 = new String[] {
        "10000", "10000", "0.2", "src\\test\\output\\bankSimulatorResult.csv"
    };
    String[] input2 = new String[] {
        "10000", "10000", "0.2", "src\\test\\output\\bankSimulatorResult.csv"
    };
    String[] input3 = new String[] {
        "100", "100", "0.2", "src\\test\\output\\bankSimulatorResult.csv"
    };
    handler1 = new InputHandler(input1);
    handler2 = new InputHandler(input2);
    handler3 = new InputHandler(input3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testException1() {
    String[] input = new String[] {
        "10000", "0.2", "src\\test\\output\\bankSimulatorResult.csv"
    };
    handler = new InputHandler(input);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testException2() {
    String[] input = new String[] {
        "100000", "10000", "0.2", "src\\test\\output\\bankSimulatorResult.csv"
    };
    handler = new InputHandler(input);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testException3() {
    String[] input = new String[] {
        "10000", "50000", "0.2", "src\\test\\output\\bankSimulatorResult.csv"
    };
    handler = new InputHandler(input);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testException4() {
    String[] input = new String[] {
        "10000", "10000", "1.3", "src\\test\\output\\bankSimulatorResult.csv"
    };
    handler = new InputHandler(input);
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(handler1.hashCode(), handler2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        handler2.hashCode() == handler3.hashCode());
  }

  @Test
  public void testEqualsNull() {
    Assert.assertEquals(false, handler1.equals(null));
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, handler1.equals(handler2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, handler2.equals(handler3));
  }

  @Test
  public void testEqualsSame() {
    IInputHandler handler4 = handler1;
    Assert.assertEquals(true, handler1.equals(handler4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    ITransactionVerification tst = new TransactionVerification();
    Assert.assertEquals(false, handler1.equals(tst));
  }
}
