package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InputHandlerTest {
  private IInputHandler handler1;
  private IInputHandler handler2;
  private IInputHandler handler3;

  @Before
  public void before() {
    handler1 = new InputHandler(new String[] {"1",
        "src\\main\\resources\\DreamCandy1.csv"});
    handler2 = new InputHandler(new String[] {"1",
        "src\\main\\resources\\DreamCandy1.csv"});
    handler3 = new InputHandler(new String[] {"1",
        "src\\main\\resources\\DreamCandy5.csv"});
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
    IHousehold house1 = new Duplex();
    Assert.assertEquals(false, handler1.equals(house1));
  }
}
