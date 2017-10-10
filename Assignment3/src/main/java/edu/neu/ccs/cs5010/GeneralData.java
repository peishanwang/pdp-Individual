package edu.neu.ccs.cs5010;

import java.util.HashMap;

/**
 * GeneralData is a class to store general information for the email-template's placeholder,
 * including Date, event, departure-city and destination-city.
 */
public class GeneralData implements IGeneralData{
  private String event;
  private String date;
  private String departureCity;
  private String destinationCity;

  /**
   * Constructor for GeneralData
   * @param event information to replace [[event]] placeholder
   * @param date information to replace [[Date]] placeholder
   * @param departureCity information to replace [[departure-city]] placeholder
   * @param destinationCity information to replace [[destination-city]] placeholder
   */
  public GeneralData(String event, String date, String departureCity, String destinationCity) {
    this.event = event;
    this.date = date;
    this.departureCity = departureCity;
    this.destinationCity = destinationCity;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HashMap<String, String> getMap() {
    HashMap<String, String> map = new HashMap<>();
    map.put("event", event);
    map.put("Date", date);
    map.put("departure-city", departureCity);
    map.put("destination-city", destinationCity);
    return map;
  }
}
