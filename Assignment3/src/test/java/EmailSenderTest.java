import edu.neu.ccs.cs5010.EmailParser;
import edu.neu.ccs.cs5010.EmailSender;
import edu.neu.ccs.cs5010.IEmailParser;
import org.junit.Before;
import org.junit.Test;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peishan on 2017/10/8.
 */
public class EmailSenderTest {
  IEmailParser email;

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

    email = new EmailParser("myself", input);
  }

  @Test(expected = RuntimeException.class)
  public void testSendEmail() {
    EmailSender.sendEmail(email, "00", "11");
  }
}
