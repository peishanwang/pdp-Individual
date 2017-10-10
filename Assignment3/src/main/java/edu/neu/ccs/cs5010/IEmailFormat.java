package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * IEmailFormat can separately store the information for writing an email
 */
public interface IEmailFormat {
  /**
   * Returns receiver's email address
   * @return receiver's email address
   */
  String getReceiver();

  /**
   * Returns the email's subject
   * @return the email's subject
   */
  String getSubject();

  /**
   * Returns the email sender's nickname
   * @return the email sender's nickname
   */
  String getSenderName();

  /**
   * Returns text of the email
   * @return text of the email
   */
  List<String> getText();
}
