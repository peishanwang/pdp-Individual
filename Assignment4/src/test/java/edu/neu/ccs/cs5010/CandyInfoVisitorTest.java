package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;


public class CandyInfoVisitorTest {
  private CandyVisitor candyInfo;

  @Before
  public void before() {
    candyInfo = new CandyInfoVisitor();
  }

  @Test(expected = CandyNotFoundException.class)
  public void testTwoType() {
    ICandyGenerator generator = new CandyGenerator();
    KingSizeCandy candy = (KingSizeCandy) generator.generateCandy("King",
        new Candy.CandyType[]{Candy.CandyType.Twix, Candy.CandyType.Mars});
    candyInfo.visit(candy);
  }
}
