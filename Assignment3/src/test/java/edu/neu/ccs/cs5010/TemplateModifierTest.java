package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TemplateModifierTest {
  private ITemplateModifier tm;
  List<String> email;

  @Before
  public void before() {
    List<String> template = new ArrayList<>();
    template.add("[[Date]]");
    template.add("");
    template.add("To: 78979629@qq.com");
    template.add("Subject: Please accept our apologies for the [[event]] of your flight");
    template.add("Dear Peishan Wang, ");
    template.add("");
    template.add("We are very sorry for the [[event]] of your flight from [[departure-city]] to [[destination-city]].");
    email = new ArrayList<>();
    email.add("2017-10-08");
    email.add("");
    email.add("To: 78979629@qq.com");
    email.add("Subject: Please accept our apologies for the delay of your flight");
    email.add("Dear Peishan Wang, ");
    email.add("");
    email.add("We are very sorry for the delay of your flight from Shenzhen to Seattle.");
    tm = new TemplateModifier(template);
  }

  @Test
  public void testModify() {
    IGeneralData gd = new GeneralData("delay", "2017-10-08", "Shenzhen", "Seattle");
    Assert.assertEquals("test modifying template: ", email, tm.modifyTemplate(gd.getMap()));
  }
}
