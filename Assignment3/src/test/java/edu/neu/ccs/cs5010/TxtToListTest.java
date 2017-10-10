package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TxtToListTest {
  private ITxtToList ttl;

  @Before
  public void before() {
    ttl = new TxtToList("src\\main\\resources\\email-template.txt");
  }

  @Test
  public void testList() {
    List<String> template = new ArrayList<>();
    template.add("[[Date]]");
    template.add("");
    template.add("To: [[email]]");
    template.add("Subject: Please accept our apologies for the [[event]] of your flight");
    template.add("Dear [[first_name]] [[last_name]], ");
    template.add("");
    StringBuilder sb = new StringBuilder();
    sb.append("We are very sorry for the [[event]] of your flight from [[departure-city]] to [[destination-city]]. ");
    sb.append("As a valued [[rewards]] member of our club your time is important to us and we will strive to improve our service in the future, and make it on time! ");
    template.add(sb.toString());
    template.add("   ");
    template.add("Sincerely, ");
    template.add("OnTime airline customer service ");
    Assert.assertEquals(template, ttl.getList());
  }

}
