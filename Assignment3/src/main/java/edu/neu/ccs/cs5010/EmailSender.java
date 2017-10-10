package edu.neu.ccs.cs5010;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * EmailSender is used to send an actual Email.
 */
public class EmailSender {

  /**
   * Send Email.
   * @param email Email information in EmailFormat.
   */
  public static void sendEmail(IEmailFormat email) {

    final String username = "sandrapswang@gmail.com";
    final String password = "wps19940723";

    Properties props = new Properties();
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
          }
        });

    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("sandrapswang@gmail.com", email.getSenderName()));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getReceiver()));
      message.setSubject(email.getSubject());
      StringBuilder sb = new StringBuilder();
      List<String> text = email.getText();
      for (int i = 0; i < text.size(); i++) {
        sb.append(text.get(i) + "\n");
      }
      message.setText(sb.toString());

      Transport.send(message);
      System.out.println("Done");

    } catch (MessagingException | UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
