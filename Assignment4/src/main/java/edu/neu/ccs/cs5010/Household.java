package edu.neu.ccs.cs5010;

import java.util.HashSet;

/**
 * Abstract class of households.
 */
public abstract class Household implements IHousehold{
  protected HashSet<ICandy> candySizeSet;

  /**
   * Constructor of Household.
   */
  public Household() {
    candySizeSet = new HashSet<>();
  }

  @Override
  public void addCandy(String size, Candy.CandyType[] types) {
    ICandyGenerator generator = new CandyGenerator();
    candySizeSet.add(generator.generateCandy(size, types));
  }

  @Override
  public boolean hasCandy(ICandy candy) {
    for (ICandy myCandy : candySizeSet) {
      if (candy.getClass().isInstance(myCandy)) {
        return myCandy.hasType(candy.getType());
      }
    }
    return false;
  }
}
