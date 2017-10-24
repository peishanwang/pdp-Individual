package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class CsvGeneratorTest {
  private ICsvGenerator generator1;
  private ICsvGenerator generator2;
  private ICsvGenerator generator3;

  @Before
  public void before() {
    HashMap<String, String> map = new HashMap<>();
    map.put("a", "aa");
    map.put("b", "bb");
    map.put("c", "cc");
    generator1 = new CsvGenerator(new String[] {"a", "b"});
    generator2 = new CsvGenerator(new String[] {"a", "b"});
    generator3 = new CsvGenerator(new String[] {"a", "b", "c"});
    generator1.addLine(map);
    generator2.addLine(map);
    generator3.addLine(map);
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(generator1.hashCode(), generator2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        generator2.hashCode() == generator3.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, generator1.equals(generator2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, generator2.equals(generator3));
  }

  @Test
  public void testEqualsSame() {
    ICsvGenerator generator4 = generator1;
    Assert.assertEquals(true, generator1.equals(generator4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    IHousehold house1 = new Duplex();
    Assert.assertEquals(false, generator1.equals(house1));
  }

}
