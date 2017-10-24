package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DetachedHouseTest {
  private IHousehold house1;
  private IHousehold house2;
  private IHousehold house3;
  private IHousehold house4;

  @Before
  public void before() {
    house1 = new DetachedHouse();
    house1.addCandy("Super",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    house2 = new DetachedHouse();
    house2.addCandy("Super",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    house3 = new DetachedHouse();
    house3.addCandy("Super",
        new Candy.CandyType[] {Candy.CandyType.Twix});
    house4 = new Townhome();
    house4.addCandy("Super",
        new Candy.CandyType[] {Candy.CandyType.Twix});
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, house1.equals(house2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, house2.equals(house3));
  }

  @Test
  public void testEqualsSame() {
    IHousehold house5 = house1;
    Assert.assertEquals(true, house1.equals(house5));
  }

  @Test
  public void testNotEqualsDiffHouse() {
    Assert.assertEquals(false, house3.equals(house4));
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(house1.hashCode(), house2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        house2.hashCode() == house3.hashCode());
  }
}
