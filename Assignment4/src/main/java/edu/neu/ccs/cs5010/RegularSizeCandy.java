package edu.neu.ccs.cs5010;

import java.util.Arrays;

/**
 * Regular Size Candy class.
 */
public class RegularSizeCandy extends Candy {

  /**
   * Constructor for regular size candy.
   */
  public RegularSizeCandy(CandyType[] types) {
    super(types);
  }

  @Override
  public <T> T accept(CandyVisitor<T> candyVisitor) {
    return candyVisitor.visit(this);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof RegularSizeCandy)) {
      return false;
    }
    RegularSizeCandy other = (RegularSizeCandy) object;
    return Arrays.equals(this.getType(), other.getType());
  }

  @Override
  public int hashCode() {
    int result = 17;
    for (Candy.CandyType type : this.getType()) {
      result = 31 * result + type.hashCode();
    }
    return result;
  }
}
