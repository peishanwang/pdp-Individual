package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Candy is an abstract class with hasType and getType methods.
 * It contains a CandyType enum, containing all 10 kinds of candies.
 * We have to input candy type(s) when we want to create specific size candies.
 */
public abstract class Candy implements ICandy{
  public enum CandyType {
    Twix, Snickers, Mars, KitKat, Whoopers, MilkyWay,
    Toblerone, Crunch, BabyRuth, AlmondJoy
  }

  private HashSet<CandyType> typeSet;

  /**
   * Constructor of Candy.
   * @param types candy type of the specific candy.
   */
  public Candy(CandyType[] types) {
    typeSet = new HashSet<>();
    for (CandyType type : types) {
      typeSet.add(type);
    }
  }

  @Override
  public boolean hasType(CandyType[] types) {
    for (CandyType type : types) {
      if (!typeSet.contains(type)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public CandyType[] getType() {
    List<CandyType> list = new ArrayList<>();
    for (CandyType type :typeSet) {
      list.add(type);
    }
    return list.toArray(new CandyType[0]);
  }
}
