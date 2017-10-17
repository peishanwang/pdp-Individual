package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;

/**
 * EmailParser can separately store the information for writing an email.
 */
public class EmailParser implements IEmailParser {
  private String receiver;
  private String subject;
  private String senderName;
  private List<String> text;
  private static final int SUBJECT_START = 9;
  private static final int TO_START = 4;

  /**
   * Constructor of EmailParser with one parameter, default sender's nickname is "sender".
   * @param info email's information
   */
  public EmailParser(List<String> info) {
    this("sender", info);
  }

  /**
   * Constructor of EmailParser with two parameters
   * @param senderName sender's nickname
   * @param info email's information
   */
  public EmailParser(String senderName, List<String> info) {
    receiver = "";
    subject = "";
    text = new ArrayList<>();
    this.senderName = senderName;
    int size = info.size();
    int textLine = Integer.MAX_VALUE;
    for (int i = 0; i < size; i++) {
      String line = info.get(i);
      if (line.startsWith("To:")) {
        receiver = line.substring(TO_START);
      } else if (line.startsWith("Subject:")) {
        subject = line.substring(SUBJECT_START);
      } else if (line.startsWith("Dear")) {
        text.add(line);
        textLine = i;
      } else if (i > textLine) {
        text.add(line);
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getReceiver() {
    return receiver;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getSubject() {
    return subject;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getSenderName() {
    return senderName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getText() {
    return text;
  }

}
