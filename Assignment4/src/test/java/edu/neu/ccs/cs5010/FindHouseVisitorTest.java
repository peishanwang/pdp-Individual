package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindHouseVisitorTest {
  private CandyVisitor candyInfo;
  private CandyVisitor visitor1;
  private CandyVisitor visitor2;
  private CandyVisitor visitor3;

  @Before
  public void before() {
    candyInfo = new FindHouseVisitor(new Neighborhood());
    IHousehold house1 = new Duplex();
    house1.addCandy("Super",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    IHousehold house2 = new Duplex();
    house2.addCandy("Super",
        new Candy.CandyType[] {Candy.CandyType.Twix});
    INeighborhood neighborhood1 = new Neighborhood();
    neighborhood1.addHousehold(house1);
    INeighborhood neighborhood2 = new Neighborhood();
    neighborhood2.addHousehold(house1);
    INeighborhood neighborhood3 = new Neighborhood();
    neighborhood3.addHousehold(house2);
    visitor1 = new FindHouseVisitor(neighborhood1);
    visitor2 = new FindHouseVisitor(neighborhood2);
    visitor3 = new FindHouseVisitor(neighborhood3);
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(visitor1.hashCode(), visitor2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        visitor2.hashCode() == visitor3.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, visitor1.equals(visitor2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, visitor2.equals(visitor3));
  }

  @Test
  public void testEqualsSame() {
    CandyVisitor visitor4 = visitor1;
    Assert.assertEquals(true, visitor1.equals(visitor4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    IHousehold house1 = new Duplex();
    Assert.assertEquals(false, visitor1.equals(house1));
  }

  @Test(expected = CandyNotFoundException.class)
  public void testNoTraversal() {
    ICandyGenerator generator = new CandyGenerator();
    KingSizeCandy candy = (KingSizeCandy) generator.generateCandy("King",
        new Candy.CandyType[]{Candy.CandyType.Twix, Candy.CandyType.Mars});
    candyInfo.visit(candy);
  }
}
