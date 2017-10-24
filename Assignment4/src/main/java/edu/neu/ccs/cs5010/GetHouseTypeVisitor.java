package edu.neu.ccs.cs5010;

/**
 * GetHouseTypeVisitor is used to get the household name of house input.
 */
public class GetHouseTypeVisitor implements HouseVisitor<String> {
  private static final String MANSION = "Mansion";
  private static final String DETACHED_HOUSE = "Detached House";
  private static final String DUPLEX = "Duplex";
  private static final String TOWNTOME = "Townhome";

  /**
   * Returns mansion's name.
   * @param house mansion
   * @return mansion's name.
   */
  public String visit(Mansion house) {
    return MANSION;
  }

  /**
   * Returns detached house's name.
   * @param house detached house
   * @return detached house's name
   */
  public String visit(DetachedHouse house) {
    return DETACHED_HOUSE;
  }

  /**
   * Returns duplex's name.
   * @param house duplex
   * @return duplex's name
   */
  public String visit(Duplex house) {
    return DUPLEX;
  }

  /**
   * Returns town home's name.
   * @param house town home
   * @return town home's name
   */
  public String visit(Townhome house) {
    return TOWNTOME;
  }
}
