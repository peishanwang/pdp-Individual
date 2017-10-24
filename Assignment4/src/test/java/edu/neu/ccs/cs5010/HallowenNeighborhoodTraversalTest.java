package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HallowenNeighborhoodTraversalTest {
  private HalloweenNeighborhoodTraversal traversal1;
  private HalloweenNeighborhoodTraversal traversal2;
  private HalloweenNeighborhoodTraversal traversal3;

  @Before
  public void before() {
    List<String> list1 = new ArrayList<>();
    list1.add("src\\main\\resources\\DreamCandy1.csv");
    List<String> list2 = new ArrayList<>();
    list2.add("src\\main\\resources\\DreamCandy1.csv");
    List<String> list3 = new ArrayList<>();
    list3.add("src\\main\\resources\\DreamCandy5.csv");
    traversal1 = new HalloweenNeighborhoodTraversal(list1);
    traversal2 = new HalloweenNeighborhoodTraversal(list2);
    traversal3 = new HalloweenNeighborhoodTraversal(list3);
  }

  @Test
  public void testEqualsHashCode() {
    Assert.assertEquals(traversal1.hashCode(), traversal2.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    Assert.assertEquals(false,
        traversal2.hashCode() == traversal3.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(true, traversal1.equals(traversal2));
  }

  @Test
  public void testNotEquals() {
    Assert.assertEquals(false, traversal2.equals(traversal3));
  }

  @Test
  public void testEqualsSame() {
    IHalloweenNeighborhoodTraversal traversal4 = traversal1;
    Assert.assertEquals(true, traversal1.equals(traversal4));
  }

  @Test
  public void testNotEqualsDiffClass() {
    IHousehold house1 = new Duplex();
    Assert.assertEquals(false, traversal1.equals(house1));
  }

  @Test
  public void testNormal() {
    String[] strs = {"3",
        "src\\main\\resources\\DreamCandy1.csv",
        "src\\main\\resources\\DreamCandy3.csv",
        "src\\main\\resources\\DreamCandy4.csv" };
    HalloweenNeighborhoodTraversal.main(strs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArguments() {
    String[] strs = {"2", "src\\main\\resources\\DreamCandy1.csv"};
    HalloweenNeighborhoodTraversal.main(strs);
  }

  @Test
  public void testFileNotFound() {
    String[] strs = {"2",
        "src\\main\\resources\\DreamCandy3.csv",
        "src\\main\\resources\\DreamCandy1.csv"};
    HalloweenNeighborhoodTraversal.main(strs);
  }

  @Test
  public void testCandyNotFound() {
    String[] strs = {"2",
        "src\\main\\resources\\DreamCandy2.csv",
        "src\\main\\resources\\DreamCandy1.csv"};
    HalloweenNeighborhoodTraversal.main(strs);
  }

}
