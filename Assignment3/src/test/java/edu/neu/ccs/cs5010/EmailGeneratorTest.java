package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;


public class EmailGeneratorTest {
  IEmailGenerator eg;

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
    eg = new OutputEmailGenerator(args);
  }

  @Test
  public void testOutput() {
    eg.generateEmail();
  }

  @Test
  public void testActualEmail() {
    String[] args = {
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\FlightMF845FromShenzhenToSeattle.csv",
        "--event",
        "arrival" };
    eg = new ActualEmailGenerator(args);
    eg.generateEmail();
  }

  @Test
  public void testMain() {
    String[] args = {
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv",
        "--event",
        "arrival" };
    EmailGenerator.main(args);
  }

  @Test(expected = PlaceholderInfoNotFoundException.class)
  public void testBadTemplate() {
    String[] args = {
        "--email-template",
        "src\\main\\resources\\bad-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\FlightMF845FromShenzhenToSeattle.csv",
        "--event",
        "arrival" };
    eg = new OutputEmailGenerator(args);
    eg.generateEmail();
  }

  @Test(expected = PlaceholderInfoNotFoundException.class)
  public void testDuplicateReplacement() {
    String[] args = {
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\FlightTstFromBadToBad.csv",
        "--event",
        "arrival" };
    eg = new OutputEmailGenerator(args);
    eg.generateEmail();
  }
}
