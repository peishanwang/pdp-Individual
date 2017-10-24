package edu.neu.ccs.cs5010;

/**
 * INeighborhood contains method to traverse all house in neighborhood.
 */
public interface INeighborhood {
  /**
   * Check whether have next house.
   * @return True if it has next house. False otherwise.
   */
  boolean hasNextHouse();

  /**
   * Returns next house.
   * @return next house.
   */
  IHousehold nextHouse();

  /**
   * Add household to the neighborhood.
   * @param house house to be added.
   */
  void addHousehold(IHousehold house);

  /**
   * Restart iterator.
   */
  void restartIterator();
}
