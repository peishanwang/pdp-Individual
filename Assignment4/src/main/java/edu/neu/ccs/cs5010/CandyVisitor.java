package edu.neu.ccs.cs5010;

/**
 * Visitor to visit each kind of candy.
 * @param <T> generic return type
 */
public interface CandyVisitor<T> {
  /**
   * Visit super size candy.
   * @param candy super size candy
   * @return generic return type
   */
  T visit(SuperSizeCandy candy);

  /**
   * Visit king size candy.
   * @param candy king size candy
   * @return generic return type
   */
  T visit(KingSizeCandy candy);

  /**
   * Visit regular size candy.
   * @param candy regular size candy
   * @return generic return type
   */
  T visit(RegularSizeCandy candy);

  /**
   * Visit fun size candy.
   * @param candy fun size candy
   * @return generic return type
   */
  T visit(FunSizeCandy candy);

}
