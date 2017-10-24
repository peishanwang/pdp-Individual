package edu.neu.ccs.cs5010;

/**
 * Interface of Candy. Containing hasType, getType and accept.
 */
public interface ICandy {
  /**
   * Check whether the Candy has specific candy type.
   * @param types types being checked
   * @return true if the Candy has specific candy type. False otherwise.
   */
  boolean hasType(Candy.CandyType[] types);

  /**
   * Returns the types of the candy.
   * @return the types of the candy
   */
  Candy.CandyType[] getType();

  /**
   * Accept visitors.
   * @param candyVisitor a Visitor has visit method for candy class
   * @param <T> generic return type
   * @return generic return type
   */
  <T> T accept(CandyVisitor<T> candyVisitor);
}
