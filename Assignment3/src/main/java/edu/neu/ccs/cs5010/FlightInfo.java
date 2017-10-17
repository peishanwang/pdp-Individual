package edu.neu.ccs.cs5010;

import java.util.HashMap;

/**
 * FlightInfo is used to store flight information.
 */
public class FlightInfo implements IFlightInfo{
  private static final String DEPARTURE_CITY = "departure-city";
  private static final String DESTINATION_CITY = "destination-city";
  private static final String FLIGHT_ID = "id";
  private static final String EVENT = "event";
  HashMap<String, String> infoMap;

  /**
   * Constructor of FlightInfo.
   * @param input InputHandler which contains information of input arguments
   */
  public FlightInfo(IInputHandler input) {
    infoMap = new HashMap<>();
    setDepartureCity(input.getDepartureCity());
    setDestinationCity(input.getDestinationCity());
    setEvent(input.getEvent());
    setFlightID(input.getFlightId());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDepartureCity() {
    return infoMap.get(DEPARTURE_CITY);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDestinationCity() {
    return infoMap.get(DESTINATION_CITY);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getFlightId() {
    return infoMap.get(FLIGHT_ID);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getEvent() {
    return infoMap.get(EVENT);
  }

  /**
   * Set departure city.
   * @param city name of the departure city
   */
  private void setDepartureCity(String city) {
    infoMap.put(DEPARTURE_CITY, city);
  }

  /**
   * Set destination city.
   * @param city name of the destination city
   */
  private void setDestinationCity(String city) {
    infoMap.put(DESTINATION_CITY, city);
  }

  /**
   * Set flight id.
   * @param id the flight id.
   */
  private void setFlightID(String id) {
    infoMap.put(FLIGHT_ID, id);
  }

  /**
   * Set event.
   * @param event string of event.
   */
  private void setEvent(String event) {
    infoMap.put(EVENT, event);
  }




}
