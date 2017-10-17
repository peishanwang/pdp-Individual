package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * ActualEmailGenerator is to generate new emails and send them actually.
 */
public class ActualEmailGenerator extends EmailGenerator{
  private static final String ADDRESS = "";
  private static final String PASSWORD = "";

  /**
   * Constructor of ActualEmailGenerator.
   * @param args input arguments
   */
  public ActualEmailGenerator(String[] args) {
    super(args);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void generateEmail() {
    super.generateEmail();
  }

  /**
   * Send the new email using mailbox.
   * @param email new email text.
   */
  @Override
  public void handleNewEmail(List<String> email) {
    IEmailParser ef = new EmailParser(email);
    EmailSender.sendEmail(ef, ADDRESS, PASSWORD);
  }
}
