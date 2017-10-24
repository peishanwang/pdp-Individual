package edu.neu.ccs.cs5010;

import static edu.neu.ccs.cs5010.Candy.CandyType.AlmondJoy;
import static edu.neu.ccs.cs5010.Candy.CandyType.BabyRuth;
import static edu.neu.ccs.cs5010.Candy.CandyType.Crunch;
import static edu.neu.ccs.cs5010.Candy.CandyType.KitKat;
import static edu.neu.ccs.cs5010.Candy.CandyType.Mars;
import static edu.neu.ccs.cs5010.Candy.CandyType.MilkyWay;
import static edu.neu.ccs.cs5010.Candy.CandyType.Snickers;
import static edu.neu.ccs.cs5010.Candy.CandyType.Toblerone;
import static edu.neu.ccs.cs5010.Candy.CandyType.Twix;
import static edu.neu.ccs.cs5010.Candy.CandyType.Whoopers;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HalloweenNeighborhoodTraversal is used to find traversal for input candy list.
 */
public class HalloweenNeighborhoodTraversal implements IHalloweenNeighborhoodTraversal {
  private static final String ENCODING = "UTF-8";
  private static final String HOUSEHOLD = "Household type";
  private static final String SIZE = "Candy Size";
  private static final String TYPE = "Candy type";
  private static final String SUPER = "Super";
  private static final String KING = "King";
  private static final String REGULAR = "Regular";
  private static final String FUN = "Fun";
  private static final String OUTPUT_PATH = "src\\main\\resources\\";
  private List<String> paths;

  /**
   * Constructor of HalloweenNeighborhoodTraversal.
   * @param paths input file path.
   */
  public HalloweenNeighborhoodTraversal(List<String> paths) {
    this.paths = paths;
  }

  /**
   * Main method.
   * @param args input arguments.
   */
  public static void main(String[] args) {
    IInputHandler input = new InputHandler(args);
    IHalloweenNeighborhoodTraversal hnt = new HalloweenNeighborhoodTraversal(input.getPaths());
    hnt.findTraversal();
  }

  @Override
  public void findTraversal() {
    INeighborhood neighborhood = buildNeighborhood();
    for (int i = 0; i < paths.size(); i++) {
      String index = "";
      try {
        Pattern pattern = Pattern.compile("DreamCandy(.*).csv");
        Matcher matcher = pattern.matcher(paths.get(i));
        if (matcher.find()) {
          index = matcher.group(1);
        }
        ICandyContainer container = new CandyContainer(paths.get(i), ENCODING);
        List<ICandy> targetCandies = container.getCandyList();
        ICsvGenerator output = new CsvGenerator(new String[] {TYPE, SIZE, HOUSEHOLD});
        for (int j = 0; j < targetCandies.size(); j++) {
          ICandy currCandy = targetCandies.get(j);
          HashMap<String, String> printInfo = currCandy.accept(new CandyInfoVisitor());
          printInfo.put(HOUSEHOLD, currCandy.accept(new FindHouseVisitor(neighborhood)));
          output.addLine(printInfo);
        }
        output.generateCsv(OUTPUT_PATH, ENCODING, index);
      } catch (RuntimeException e) {
        System.out.println(e);
      }
    }
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof HalloweenNeighborhoodTraversal)) {
      return false;
    }
    HalloweenNeighborhoodTraversal other = (HalloweenNeighborhoodTraversal) object;
    return this.paths.equals(other.paths);
  }

  @Override
  public int hashCode() {
    int result = 17;
    for (String path : paths) {
      result = 31 * result + path.hashCode();
    }
    return result;
  }

  /**
   * Set neighborhood knowledge.
   * @return neighborhood object
   */
  private INeighborhood buildNeighborhood() {
    //create mansion
    Mansion mansion = new Mansion();
    mansion.addCandy(SUPER, new Candy.CandyType[] {Twix, Snickers, Mars});
    mansion.addCandy(KING, new Candy.CandyType[] {KitKat, Whoopers, Crunch});
    mansion.addCandy(FUN, new Candy.CandyType[] {Toblerone, BabyRuth, AlmondJoy});
    //create detached house
    DetachedHouse detachedHouse = new DetachedHouse();
    detachedHouse.addCandy(SUPER, new Candy.CandyType[] {KitKat, Whoopers, MilkyWay, Crunch});
    detachedHouse.addCandy(KING, new Candy.CandyType[] {Toblerone});
    detachedHouse.addCandy(FUN, new Candy.CandyType[] {Twix, Snickers, Mars});
    //create duplex
    Duplex duplex = new Duplex();
    duplex.addCandy(SUPER, new Candy.CandyType[] {Toblerone, BabyRuth, AlmondJoy});
    duplex.addCandy(KING, new Candy.CandyType[] {Twix, Snickers, Mars});
    duplex.addCandy(FUN, new Candy.CandyType[] {KitKat, Whoopers, MilkyWay, Crunch});
    //create town home
    Townhome townhome = new Townhome();
    townhome.addCandy(REGULAR, new Candy.CandyType[] {
        Twix, Snickers, Mars, KitKat, Whoopers, Toblerone, BabyRuth, AlmondJoy});
    //create neighborhood
    INeighborhood neighborhood = new Neighborhood();
    neighborhood.addHousehold(mansion);
    neighborhood.addHousehold(detachedHouse);
    neighborhood.addHousehold(duplex);
    neighborhood.addHousehold(townhome);
    return neighborhood;
  }
}
