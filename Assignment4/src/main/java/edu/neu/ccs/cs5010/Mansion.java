package edu.neu.ccs.cs5010;

/**
 * Class of mansion.
 */
public class Mansion extends Household {

  @Override
  public <T> T accept(HouseVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof Mansion)) {
      return false;
    }
    Mansion other = (Mansion) object;
    return this.candySizeSet.equals(other.candySizeSet);
  }

  @Override
  public int hashCode() {
    int result = 17;
    for (ICandy candy : candySizeSet) {
      result = 31 * result + candy.hashCode();
    }
    return result;
  }
}
