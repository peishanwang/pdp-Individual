package edu.neu.ccs.cs5010;


/**
 * IFlightInfo is the Interface of FlightInfo. It can returns the
 * flight's information.
 */
public interface IFlightInfo {
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
   * Returns id of the flight.
   * @return id of the flight.
   */
  String getFlightId();

  /**
   * Returns the event.
   * @return the event.
   */
  String getEvent();
}
