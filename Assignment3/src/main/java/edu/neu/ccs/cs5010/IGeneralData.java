package edu.neu.ccs.cs5010;

import java.util.HashMap;

/**
 * IGeneralData is to store general information for the email-template's placeholder,
 * including Date, event, departure-city and destination-city.
 */
public interface IGeneralData {
  /**
   * Returns a HashMap which contains the needed general data
   * @return HashMap which contains the needed general data. Keys are the name of Placeholder,
   * and values are the replacement information.
   */
  HashMap<String, String> getMap();
}
