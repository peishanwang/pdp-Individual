package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;

/**
 * EmailFormat can separately store the information for writing an email
 */
public class EmailFormat implements IEmailFormat{
  private String receiver;
  private String subject;
  private String senderName;
  private List<String> text;
  private final static int SUBJECT_START = 9;
  private final static int TO_START = 4;

  /**
   * Constructor of EmailFormat with one parameter, default sender's nickname is "sender".
   * @param info email's information
   */
  public EmailFormat(List<String> info) {
    this("sender", info);
  }

  /**
   * Constructor of EmailFormat with two parameters
   * @param senderName sender's nickname
   * @param info email's information
   */
  public EmailFormat(String senderName, List<String> info) {
    receiver = "";
    subject = "";
    text = new ArrayList<>();
    this.senderName = senderName;
    int size = info.size(), textLine = Integer.MAX_VALUE;
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
