package edu.neu.ccs.cs5010;

/**
 * ICandyGenerator interface contains methods to generate candy.
 */
public interface ICandyGenerator {
  /**
   * Generate candy using candy size and a candy type.
   * @param candySize size of the candy
   * @param candyType type of the candy
   * @return new candy
   */
  ICandy generateCandy(String candySize, String candyType);

  /**
   * Generate candy using candy size and candy types.
   * @param candySize size of the candy
   * @param candyTypes types of the candy
   * @return new candy
   */
  ICandy generateCandy(String candySize, Candy.CandyType[] candyTypes);
}
