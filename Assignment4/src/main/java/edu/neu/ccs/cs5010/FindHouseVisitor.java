package edu.neu.ccs.cs5010;


/**
 * FindHouseVisitor is used to find the household which contains the specific candy.
 * Throw CandyNotFoundException when all the households in neighborhood don't contain
 * this kind of candy.
 */
public class FindHouseVisitor implements CandyVisitor<String> {
  private INeighborhood neighborhood;

  /**
   * Constructor of FindHouseVisitor.
   * @param neighborhood neighborhood containing knowledge
   */
  public FindHouseVisitor(INeighborhood neighborhood) {
    neighborhood.restartIterator();
    this.neighborhood = neighborhood;
  }

  /**
   * Returns household name contains super size candy of specific type.
   * @param candy super size candy
   * @return household name contains super size candy of specific type.
   */
  public String visit(SuperSizeCandy candy) {
    return checkCandy(candy);
  }

  /**
   * Returns household name contains king size candy of specific type.
   * @param candy king size candy
   * @return household name contains king size candy of specific type.
   */
  public String visit(KingSizeCandy candy) {
    return checkCandy(candy);
  }

  /**
   * Returns household name contains regular size candy of specific type.
   * @param candy regular size candy
   * @return household name contains regular size candy of specific type.
   */
  public String visit(RegularSizeCandy candy) {
    return checkCandy(candy);
  }

  /**
   * Returns household name contains fun size candy of specific type.
   * @param candy fun size candy
   * @return household name contains fun size candy of specific type.
   */
  public String visit(FunSizeCandy candy) {
    return checkCandy(candy);
  }

  /**
   * Check which household contains the input candy.
   * @param candy candy to be checked.
   * @return name of household which contains the input candy.
   */
  private String checkCandy(ICandy candy) {
    while (neighborhood.hasNextHouse()) {
      IHousehold currHouse = neighborhood.nextHouse();
      if (currHouse.hasCandy(candy)) {
        return currHouse.accept(new GetHouseTypeVisitor());
      }
    }
    throw new CandyNotFoundException("No traversal exists");
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof FindHouseVisitor)) {
      return false;
    }
    FindHouseVisitor other = (FindHouseVisitor) object;
    return this.neighborhood.equals(other.neighborhood);
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + neighborhood.hashCode();
    return result;
  }
}
