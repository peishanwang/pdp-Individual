package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyContainerTest {
  private ICandyContainer container1;
  private ICandyContainer container2;
  private ICandyContainer container3;

  @Before
  public void before() {
    container1 = new CandyContainer("src\\main\\resources\\DreamCandy1.csv",
        "UTF-8");
    container2 = new CandyContainer("src\\main\\resources\\DreamCandy1.csv",
        "UTF-8");
    container3 = new CandyContainer("src\\main\\resources\\DreamCandy5.csv",
        "UTF-8");
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(container1.hashCode(), container2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        container2.hashCode() == container3.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, container1.equals(container2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, container2.equals(container3));
  }

  @Test
  public void testEqualsSame() {
    ICandyContainer container4 = container1;
    Assert.assertEquals(true, container1.equals(container4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    IHousehold house1 = new Duplex();
    Assert.assertEquals(false, container1.equals(house1));
  }

}
