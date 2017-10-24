package edu.neu.ccs.cs5010;

/**
 * CandyGenerator is used to generate new candy.
 */
public class CandyGenerator implements ICandyGenerator{
  private static final String SUPER = "Super";
  private static final String KING = "King";
  private static final String REGULAR = "Regular";
  private static final String FUN = "Fun";
  private static final String DEFAULT = "";

  @Override
  public ICandy generateCandy(String size, Candy.CandyType[] types) {
    switch (size) {
      case SUPER :
        return new SuperSizeCandy(types);
      case KING :
        return new KingSizeCandy(types);
      case REGULAR :
      case DEFAULT :
        return new RegularSizeCandy(types);
      case FUN :
        return new FunSizeCandy(types);
      default:
        throw new CandyNotFoundException("Their is no this type of candy size: " + size);
    }
  }

  @Override
  public ICandy generateCandy(String candySize, String candyType) {
    return generateCandy(candySize, new Candy.CandyType[]{stringToType(candyType)});
  }

  /**
   * Convert string to CandyType type.
   * @param str String of candy type
   * @return CandyType type
   */
  private Candy.CandyType stringToType(String str) {
    for (Candy.CandyType type : Candy.CandyType.values()) {
      if (type.toString().equals(str)) {
        return type;
      }
    }
    throw new CandyNotFoundException("Undefined candy type: " + str);
  }

}
