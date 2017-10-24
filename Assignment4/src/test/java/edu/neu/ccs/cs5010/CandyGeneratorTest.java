package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

public class CandyGeneratorTest {
  private ICandyGenerator generator;

  @Before
  public void before() {
    generator = new CandyGenerator();
  }

  @Test(expected = CandyNotFoundException.class)
  public void testIllegalSize() {
    generator.generateCandy("Big", "Twix");
  }
}
