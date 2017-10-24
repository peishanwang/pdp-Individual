package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegularSizeCandyTest {
  private ICandyGenerator generator;

  @Before
  public void before() {
    generator = new CandyGenerator();
  }

  @Test
  public void testEquals() {
    ICandy candy1 = generator.generateCandy("Regular",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    ICandy candy2 = generator.generateCandy("Regular",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    Assert.assertEquals(true, candy1.equals(candy2));
  }

  @Test
  public void testNotEquals() {
    ICandy candy1 = generator.generateCandy("Regular", "Twix");
    ICandy candy2 = generator.generateCandy("Regular",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    Assert.assertEquals(false, candy1.equals(candy2));
  }

  @Test
  public void testEqualsSame() {
    ICandy candy1 = generator.generateCandy("Regular", "Twix");
    ICandy candy2 = candy1;
    Assert.assertEquals(true, candy1.equals(candy2));
  }

  @Test
  public void testNotEqualsDiffSize() {
    ICandy candy1 = generator.generateCandy("Regular", "Twix");
    ICandy candy2 = generator.generateCandy("King",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    Assert.assertEquals(false, candy1.equals(candy2));
  }

  @Test
  public void testHashCodeEquals() {
    ICandy candy1 = generator.generateCandy("Regular", "Twix");
    ICandy candy2 = generator.generateCandy("Regular",
        new Candy.CandyType[] {Candy.CandyType.Twix});
    Assert.assertEquals(candy1.hashCode(), candy2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    ICandy candy1 = generator.generateCandy("Regular", "Twix");
    ICandy candy2 = generator.generateCandy("Regular",
        new Candy.CandyType[] {Candy.CandyType.Twix, Candy.CandyType.Mars});
    Assert.assertEquals(false,
        candy1.hashCode() == candy2.hashCode());
  }
}
