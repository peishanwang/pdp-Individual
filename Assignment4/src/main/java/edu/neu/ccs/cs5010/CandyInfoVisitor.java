package edu.neu.ccs.cs5010;

import java.util.HashMap;

/**
 * CandyInfoVisitor is used to get candy's size and candy's type.
 */
public class CandyInfoVisitor implements CandyVisitor<HashMap<String, String>> {
  private static final String SIZE = "Candy Size";
  private static final String TYPE = "Candy type";
  private static final String SUPER = "Super Size";
  private static final String KING = "King Size";
  private static final String REGULAR = "Regular Size";
  private static final String FUN = "Fun Size";
  private static final String BEFORE1 = "KitKat";
  private static final String AFTER1 = "Kit Kat";
  private static final String BEFORE2 = "MilkyWay";
  private static final String AFTER2 = "Milky Way";
  private static final String BEFORE3 = "BabyRuth";
  private static final String AFTER3 = "Baby Ruth";
  private static final String BEFORE4 = "AlmondJoy";
  private static final String AFTER4 = "Almond Joy";


  /**
   * Returns candy's size and candy's type.
   * @param candy super size candy
   * @return candy's size and candy's type.
   */
  public HashMap<String, String> visit(SuperSizeCandy candy) {
    HashMap<String, String> map = initializeMap(candy);
    map.put(SIZE, SUPER);
    return map;
  }

  /**
   * Returns candy's size and candy's type.
   * @param candy king size candy
   * @return candy's size and candy's type.
   */
  public HashMap<String, String> visit(KingSizeCandy candy) {
    HashMap<String, String> map = initializeMap(candy);
    map.put(SIZE, KING);
    return map;
  }

  /**
   * Returns candy's size and candy's type.
   * @param candy regular size candy
   * @return candy's size and candy's type.
   */
  public HashMap<String, String> visit(RegularSizeCandy candy) {
    HashMap<String, String> map = initializeMap(candy);
    map.put(SIZE, REGULAR);
    return map;
  }

  /**
   * Returns candy's size and candy's type.
   * @param candy fun size candy
   * @return candy's size and candy's type.
   */
  public HashMap<String, String> visit(FunSizeCandy candy) {
    HashMap<String, String> map = initializeMap(candy);
    map.put(SIZE, FUN);
    return map;
  }

  /**
   * Returns a map with candy's size information.
   * @param candy a candy to be analyzed
   * @return a map with candy's size information
   */
  private HashMap<String, String> initializeMap(ICandy candy) {
    HashMap<String, String> map = new HashMap<>();
    map.put(TYPE, getTypeString(candy.getType()));
    return map;
  }

  /**
   * Returns specific format of candy type name.
   * @param types candy type name without space
   * @return candy type name with space
   */
  private String getTypeString(Candy.CandyType[] types) {
    if (types.length == 1) {
      String str = types[0].toString();
      switch (str) {
        case BEFORE1:
          return AFTER1;
        case BEFORE2:
          return AFTER2;
        case BEFORE3:
          return AFTER3;
        case BEFORE4:
          return AFTER4;
        default:
          return str;
      }
    } else {
      throw new CandyNotFoundException("Cannot print more than one type at a time");
    }
  }
}
