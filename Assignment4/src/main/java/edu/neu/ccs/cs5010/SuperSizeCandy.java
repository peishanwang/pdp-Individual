package edu.neu.ccs.cs5010;

import java.util.Arrays;

/**
 * Super Size Candy class.
 */
public class SuperSizeCandy extends Candy {

  /**
   * Constructor for super size candy.
   */
  public SuperSizeCandy(CandyType[] types) {
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
    if (!(object instanceof SuperSizeCandy)) {
      return false;
    }
    SuperSizeCandy other = (SuperSizeCandy) object;
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
