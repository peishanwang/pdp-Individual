package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightInfoTest {
  IFlightInfo flightInfo;

  @Before
  public void before() {
    String[] args = {
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv",
        "--event",
        "arrival" };
    IInputHandler input = new InputHandler(args);
    flightInfo = new FlightInfo(input);
  }

  @Test
  public void testId() {
    Assert.assertEquals("3", flightInfo.getFlightId());
  }
}
