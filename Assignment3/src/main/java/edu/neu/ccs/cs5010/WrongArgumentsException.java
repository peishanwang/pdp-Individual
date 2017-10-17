package edu.neu.ccs.cs5010;

public class WrongArgumentsException extends RuntimeException{

  public WrongArgumentsException(String s) {
    super(s + "\n"
        + "Usage:\n"
        + "--email-template <file> accepts a filename that holds the email template.\n"
        + "--output-dir <path> accepts the name of a folder, all output is placed in this folder\n"
        + "--csv-file <path> accepts the name of the csv file to process, in a following format\n"
        + "Flight<id>From<departure-city>To<destination-city>.csv\n"
        + "--event <details> specifies if the delay refers to departure/arrival\n"
        + "For example:\n"
        + "--email-template email-template.txt --output-dir emails"
        + "--csv-file Flight363FromSeattleToBoston.csv –-event arrival");
  }
}
