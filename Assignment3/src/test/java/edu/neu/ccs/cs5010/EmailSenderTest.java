package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peishan on 2017/10/8.
 */
public class EmailSenderTest {
  EmailFormat email;

  @Before
  public void before() {
    List<String> input = new ArrayList<>();
    input.add("To: 78979629@qq.com");
    input.add("Subject: test email");
    input.add("");
    input.add("Dear Peishan,");
    input.add("");
    input.add("Have a nice day!");
    input.add("");
    input.add("Sincerely,");
    input.add("Myself");

    email = new EmailFormat("myself", input);
  }

  @Test
  public void testSendEmail() {
    EmailSender.sendEmail(email);
  }
}
