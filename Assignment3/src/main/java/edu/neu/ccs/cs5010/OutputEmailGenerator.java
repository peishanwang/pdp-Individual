package edu.neu.ccs.cs5010;

import java.util.List;

/**
 *  OutputEmailGenerator is to generate new emails and save them to specific directory.
 */
public class OutputEmailGenerator extends EmailGenerator {
  private static int number = 1;
  private static final String FILENAME = "email";

  /**
   * Constructor of OutputEmailGenerator
   * @param args input arguments
   */
  public OutputEmailGenerator(String[] args) {
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
   * Save the new email to the specific directory.
   * @param email new email text.
   */
  @Override
  public void handleNewEmail(List<String> email) {
    String fileName = FILENAME + (number < 10 ? "0" : "") + (number++) + ".txt";
    IIOUtil ioUtil = new IOUtil(parameters.getOutputDir(), "UTF-8");
    ioUtil.generateOutput(email, fileName);
  }
}
