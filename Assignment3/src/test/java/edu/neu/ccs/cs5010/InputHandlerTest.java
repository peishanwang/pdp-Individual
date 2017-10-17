package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputHandlerTest {
  private InputHandler iph;

  @Before
  public void before() {
    //normal
    String[] args = {
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv",
        "--event",
        "arrival" };
    iph = new InputHandler(args);
  }

  @Test
  public void testCSV() {
    Assert.assertEquals("src\\main\\resources\\Flight3FromVancouverToSeattle.csv", iph.getCSVPath());
  }

  @Test
  public void testTemplate() {
    Assert.assertEquals("src\\main\\resources\\email-template.txt", iph.getTemplate());
  }

  @Test
  public void testOutputDir() {
    Assert.assertEquals("src\\test\\output\\", iph.getOutputDir());
  }

  @Test
  public void testFlightId() {
    Assert.assertEquals("3", iph.getFlightId());

  }

  @Test(expected = WrongArgumentsException.class)
  public void testLack() {
    String[] args = new String[]{
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir"};
    iph = new InputHandler(args);

  }

  @Test(expected = WrongArgumentsException.class)
  public void testNotEnough() {
    String[] args = new String[]{
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv",
        "--event",
        "arrival"};
    iph = new InputHandler(args);
  }

  @Test(expected = WrongArgumentsException.class)
  public void testUnresolved() {
    String[] args = new String[]{
        "-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv",
        "--event",
        "arrival" };
    iph = new InputHandler(args);
  }

  @Test(expected = WrongArgumentsException.class)
  public void testCSVName() {
    String[] args = new String[]{
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverTo.csv",
        "--event",
        "arrival"};
    iph = new InputHandler(args);
  }

  @Test(expected = WrongArgumentsException.class)
  public void testEventName() {
    String[] args = new String[]{
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv",
        "--event",
        "stop"};
    iph = new InputHandler(args);
  }

  @Test(expected = WrongArgumentsException.class)
  public void testWrongArgu() {
    String[] args = new String[]{
        "--email-template",
        "--src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv",
        "--event",
        "stop"};
    iph = new InputHandler(args);
  }
}
