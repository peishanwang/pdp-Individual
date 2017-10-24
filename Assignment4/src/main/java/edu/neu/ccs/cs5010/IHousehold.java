package edu.neu.ccs.cs5010;

/**
 * Interface of household.
 */
public interface IHousehold {
  /**
   * Add candy to the household.
   * @param size candy size
   * @param types candy types
   */
  void addCandy(String size, Candy.CandyType[] types);

  /**
   * Check whether the house contains specific candy.
   * @param candy target candy
   * @return true if the household contains specific candy. False otherwise.
   */
  boolean hasCandy(ICandy candy);

  /**
   * Accept household visitor.
   * @param visitor an object of household visitor.
   * @param <T> generic return type
   * @return generic return type
   */
  <T> T accept(HouseVisitor<T> visitor);
}
