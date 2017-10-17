package edu.neu.ccs.cs5010;

/**
 * IIPutHandler is the interface of InputHandler. It can get useful information
 * from the input arguments.
 *
 * @see InputHandler
 */
public interface IInputHandler {
  /**
   * Returns the path of csv file.
   * @return the path of csv file.
   */
  String getCSVPath();

  /**
   * Returns the path of template file.
   * @return the path of template file.
   */
  String getTemplate();

  /**
   * Returns the path of output directory.
   * @return the path of output directory.
   */
  String getOutputDir();

  /**
   * Returns the name of departure city.
   * @return the name of departure city.
   */
  String getDepartureCity();

  /**
   * Returns the name of destination city.
   * @return the name of destination city.
   */
  String getDestinationCity();

  /**
   * Returns the event.
   * @return the event.
   */
  String getEvent();

  /**
   * Returns id of the flight.
   * @return id of the flight.
   */
  String getFlightId();
}
