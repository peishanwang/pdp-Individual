package edu.neu.ccs.cs5010;

/**
 * IEmailGenerator is used to generate a email by importing email-template,
 * customers' data, output directory, and event.
 */
public interface IEmailGenerator{
  /**
   * Generate emails and save them to output directory or send them as actual Email.
   * @param outputType If outputType is 0, the new Emails will be saved to assigned
   *                   output directory. If outputType is 1, the new Emails will be
   *                   sent through gmail.
   */
  void generateEmail(int outputType);
}
