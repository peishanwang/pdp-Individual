package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Neighborhood is a class contains all house-candy knowledge.
 */
public class Neighborhood implements INeighborhood {
  private List<IHousehold> households;
  private Iterator<IHousehold> ite;

  /**
   * Constructor of Neighborhood.
   */
  public Neighborhood() {
    households = new ArrayList<>();
  }

  @Override
  public boolean hasNextHouse() {
    return ite.hasNext();
  }

  @Override
  public IHousehold nextHouse() {
    return ite.next();
  }

  @Override
  public void restartIterator() {
    ite = households.iterator();
  }

  @Override
  public void addHousehold(IHousehold house) {
    households.add(house);
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof Neighborhood)) {
      return false;
    }
    Neighborhood other = (Neighborhood) object;
    return this.households.equals(other.households);
  }

  @Override
  public int hashCode() {
    int result = 17;
    for (IHousehold house : households) {
      result = 31 * result + house.hashCode();
    }
    return result;
  }
}
