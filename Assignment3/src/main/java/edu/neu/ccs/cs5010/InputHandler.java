package edu.neu.ccs.cs5010;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * InputHandler is used to handle the input from command line.
 */
public class InputHandler implements IInputHandler{
  private HashMap<String, String> argsMap;
  private FlightInfo flightInfo;
  private static final String TEMPLATE = "--email-template";
  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV = "--csv-file";
  private static final String EVENT = "--event";
  private static final String DEPARTURE_CITY = "departure-city";
  private static final String DESTINATION_CITY = "destination-city";
  private static final String FLIGHT_ID = "id";

  /**
   * Constructor of InputHandler.
   * @param args input arguments
   */
  public InputHandler(String[] args) {
    argsMap = new HashMap<>();
    handleArguments(args);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getCSVPath() {
    return argsMap.get(CSV);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getTemplate() {
    return argsMap.get(TEMPLATE);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getOutputDir() {
    return argsMap.get(OUTPUT_DIR);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDepartureCity() {
    return argsMap.get(DEPARTURE_CITY);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDestinationCity() {
    return argsMap.get(DESTINATION_CITY);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getEvent() {
    return argsMap.get(EVENT);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getFlightId() {
    return argsMap.get(FLIGHT_ID);
  }

  /**
   * helper method to store the input arguments to map
   * @param args input arguments
   */
  private void handleArguments(String[] args) {
    HashSet<String> neededArgs = new HashSet<>();
    String[] strArgs = {TEMPLATE, OUTPUT_DIR, CSV, EVENT};
    Collections.addAll(neededArgs, strArgs);
    for (int i = 0; i < args.length - 1; i += 2) {
      if (neededArgs.contains(args[i])) {
        if (!args[i + 1].startsWith("--")) {
          argsMap.put(args[i], args[i + 1]);
          neededArgs.remove(args[i]);
        } else {
          throw new WrongArgumentsException(args[i] + "is given without providing appropriate arguments.");
        }
      } else {
        throw new WrongArgumentsException("Can not resolve argument: " + args[i]);
      }
    }
    if (neededArgs.size() != 0) {
      StringBuilder sb = new StringBuilder();
      for (String str : neededArgs) {
        sb.append(str + " ");
      }
      throw new WrongArgumentsException("lack of arguments :" + sb);
    }
    checkArgs();
  }

  /**
   * helper method to check whether all the input arguments are legal.
   */
  private void checkArgs() {
    checkCSV();
    checkEvent();
  }

  /**
   * helper method to check whether csv argument is legal.
   */
  private void checkCSV() {
    Pattern pattern = Pattern.compile("Flight(.*?)From(.*?)To(.*?).csv");
    Matcher matcher = pattern.matcher(argsMap.get(CSV));
    if (matcher.find() && !matcher.group(1).equals("")
        && !matcher.group(2).equals("") && !matcher.group(3).equals("")) {
      argsMap.put(FLIGHT_ID, matcher.group(1));
      argsMap.put(DEPARTURE_CITY, matcher.group(2));
      argsMap.put(DESTINATION_CITY, matcher.group(3));
    } else {
      throw new WrongArgumentsException("--csv-file argument does not contain enough information");
    }
  }

  /**
   * helper method to check whether event argument is legal.
   */
  private void checkEvent() {
    String event = argsMap.get(EVENT);
    if (!event.equals("arrival") && !event.equals("departure")) {
      throw new WrongArgumentsException("--event argument is not arrival or departure");
    }
  }

}
