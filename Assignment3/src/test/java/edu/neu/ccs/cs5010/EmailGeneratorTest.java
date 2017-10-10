package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class EmailGeneratorTest {
  private IEmailGenerator eg1, eg2;

  @Before
  public void before() {
    List<String> items = new ArrayList<>();
    items.add("first_name");
    items.add("last_name");
    items.add("email");
    items.add("rewards");
    GeneralData gd1 = new GeneralData("delay", "2017-10-09", "Vancouver", "Seattle");
    eg1 = new EmailGenerator(gd1,
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv",
        items,
        "src\\test\\output\\",
        "src\\main\\resources\\email-template.txt"
        );
    GeneralData gd2 = new GeneralData("delay", "2017-10-09", "Shenzhen", "Seattle");
    eg2 = new EmailGenerator(gd2,
        "src\\main\\resources\\FlightMF845FromShenzhenToSeattle.csv",
        items,
        "src\\test\\output\\",
        "src\\main\\resources\\email-template.txt"
    );
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
        "delay"};
    try {
      EmailGenerator.main(args);
    } catch (IllegalArgumentException ex) {
      fail("Threw IllegalArgumentException for legal input" + ex);
    }
  }

  @Test(expected = LackOfArgumentException.class)
  public void testMain2() {
    String[] args = {
        "--email-template",
        "src\\main\\resources\\email-template.txt",
        "--output-dir",
        "src\\test\\output\\",
        "--csv-file",
        "src\\main\\resources\\Flight3FromVancouverToSeattle.csv"};
    EmailGenerator.main(args);
  }

  @Test
  public void testGenerateEmail0() {
    eg1.generateEmail(0);
  }

  @Test
  public void testGenerateEmail1() {
    eg2.generateEmail(1);
  }
}
