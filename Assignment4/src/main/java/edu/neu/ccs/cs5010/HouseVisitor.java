package edu.neu.ccs.cs5010;

/**
 * Visitor to visit ezch kind of household.
 * @param <T> generic return type
 */
public interface HouseVisitor<T> {
  /**
   * Visit Mansion.
   * @param house mansion
   * @return generic return type
   */
  T visit(Mansion house);

  /**
   * Visit detached house.
   * @param house detached house
   * @return generic return type
   */
  T visit(DetachedHouse house);

  /**
   * Visit duplex.
   * @param house duplex
   * @return generic return type
   */
  T visit(Duplex house);

  /**
   * Visit town home.
   * @param house town home
   * @return generic return type
   */
  T visit(Townhome house);
}
