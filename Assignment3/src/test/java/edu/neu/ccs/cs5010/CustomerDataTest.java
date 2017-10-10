package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by peishan on 2017/10/7.
 */
public class CustomerDataTest {
  private ICustomerData cd, cd2;

  @Before
  public void before() {
    List<String> items = new ArrayList<>();
    items.add("first_name");
    items.add("last_name");
    items.add("email");
    items.add("rewards");
    String path = "src\\main\\resources\\Flight3FromVancouverToSeattle.csv";
    cd = new CustomerData(path, items);
  }

  /**
   * Tests data
   */
  @Test
  public void testData() {
    HashMap<String, List<String>> data = cd.getData();
    Assert.assertEquals("get last_name of the first customer: ", "Butt", data.get("last_name").get(0));
  }

  /**
   * Tests getSize()
   */
  @Test
  public void testSize() {
    Assert.assertEquals("get customer data size: ", 3, cd.getSize());
  }

  /**
   * Tests exception
   */
  @Test(expected = NeededDataNotProvidedException.class)
  public void testException() {
    List<String> items = new ArrayList<>();
    items.add("first_name");
    items.add("last_name");
    items.add("email");
    items.add("rewards");
    items.add("else");
    CustomerData cd2 = new CustomerData("src\\main\\resources\\Flight3FromVancouverToSeattle.csv", items);
  }


}
