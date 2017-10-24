package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CsvParserTest {
  private ICsvParser parser1;
  private ICsvParser parser2;
  private ICsvParser parser3;

  @Before
  public void before() {
    parser1 = new CsvParser("src\\main\\resources\\DreamCandy1.csv",
        "UTF-8");
    parser2 = new CsvParser("src\\main\\resources\\DreamCandy1.csv",
        "UTF-8");
    parser3 = new CsvParser("src\\main\\resources\\DreamCandy5.csv",
        "UTF-8");
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(parser1.hashCode(), parser2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        parser2.hashCode() == parser3.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, parser1.equals(parser2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, parser2.equals(parser3));
  }

  @Test
  public void testEqualsSame() {
    ICsvParser parser4 = parser1;
    Assert.assertEquals(true, parser1.equals(parser4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    IHousehold house1 = new Duplex();
    Assert.assertEquals(false, parser1.equals(house1));
  }
}
