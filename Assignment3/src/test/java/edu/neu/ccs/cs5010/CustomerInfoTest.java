package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerInfoTest {
  ICustomerInfo ci;

  @Before
  public void before() {
    ci = new CustomerInfo("src\\main\\resources\\testCSV.csv");
  }

  @Test
  public void testGetHeaders() {
    List<String> headers = new ArrayList<>();
    headers.add("first_name");
    headers.add("last_name");
    Assert.assertEquals(headers, ci.getHeaders());
  }

  @Test
  public void testHasNext() {
    Assert.assertEquals(true, ci.hasNextCustomer());
  }

  @Test
  public void testNext() {
    List<String> customer1 = new ArrayList<>();
    customer1.add("James");
    customer1.add("Butt");
    Assert.assertEquals(customer1, ci.nextCustomer());
    ci.nextCustomer();
    ci.nextCustomer();
    Assert.assertEquals(false, ci.hasNextCustomer());
  }
}
