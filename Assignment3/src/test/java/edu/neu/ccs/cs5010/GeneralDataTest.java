package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class GeneralDataTest {
  private IGeneralData gd;

  @Before
  public void before() {
    gd = new GeneralData("delay", "2017-10-08", "Shenzhen", "Seattle");
  }

  @Test
  public void testGetMap() {
    HashMap<String, String> map = new HashMap<>();
    map.put("event", "delay");
    map.put("Date", "2017-10-08");
    map.put("departure-city", "Shenzhen");
    map.put("destination-city", "Seattle");
    Assert.assertEquals(map, gd.getMap());
  }
}
