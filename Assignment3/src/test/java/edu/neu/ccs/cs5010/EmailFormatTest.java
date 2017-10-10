package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmailFormatTest {
  private IEmailFormat ef;
  List<String> text;

  @Before
  public void before() {
    List<String> email = new ArrayList<>();
    email.add("2017-10-08");
    email.add("");
    email.add("To: 78979629@qq.com");
    email.add("Subject: Please accept our apologies for the delay of your flight");
    email.add("Dear Peishan Wang, ");
    email.add("");
    email.add("We are very sorry for the delay of your flight from Shenzhen to Seattle. As a valued gold member of our club ");
    email.add("your time is important to us and we will strive to improve our service in the future, and make it on time! ");
    email.add("");
    email.add("Sincerely, ");
    email.add("OnTime airline customer service ");
    text = new ArrayList<>();
    text.add("Dear Peishan Wang, ");
    text.add("");
    text.add("We are very sorry for the delay of your flight from Shenzhen to Seattle. As a valued gold member of our club ");
    text.add("your time is important to us and we will strive to improve our service in the future, and make it on time! ");
    text.add("");
    text.add("Sincerely, ");
    text.add("OnTime airline customer service ");


    ef = new EmailFormat("tester",email);
  }

  @Test
  public void testName() {
    Assert.assertEquals("test sender's name: ","tester", ef.getSenderName());
  }

  @Test
  public void testText() {
    Assert.assertEquals("test text: ", text, ef.getText());
  }

  @Test
  public void testSubject() {
    Assert.assertEquals("test subject: ", "Please accept our apologies for the delay of your flight", ef.getSubject());
  }

  @Test
  public void testReceiver() {
    Assert.assertEquals("test receiver: ", "78979629@qq.com", ef.getReceiver());
  }

}
