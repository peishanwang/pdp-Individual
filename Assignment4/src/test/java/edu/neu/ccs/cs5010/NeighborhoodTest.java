package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NeighborhoodTest {
  private INeighborhood neighborhood1;
  private INeighborhood neighborhood2;
  private INeighborhood neighborhood3;

  @Before
  public void before() {
    IHousehold house1 = new Duplex();
    house1.addCandy("Super",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    IHousehold house2 = new Duplex();
    house2.addCandy("Super",
        new Candy.CandyType[] {Candy.CandyType.Twix});
    neighborhood1 = new Neighborhood();
    neighborhood1.addHousehold(house1);
    neighborhood2 = new Neighborhood();
    neighborhood2.addHousehold(house1);
    neighborhood3 = new Neighborhood();
    neighborhood3.addHousehold(house2);
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(neighborhood1.hashCode(), neighborhood2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        neighborhood2.hashCode() == neighborhood3.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, neighborhood1.equals(neighborhood2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, neighborhood2.equals(neighborhood3));
  }

  @Test
  public void testEqualsSame() {
    INeighborhood neighborhood4 = neighborhood1;
    Assert.assertEquals(true, neighborhood1.equals(neighborhood4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    IHousehold house1 = new Duplex();
    Assert.assertEquals(false, neighborhood1.equals(house1));
  }
}
