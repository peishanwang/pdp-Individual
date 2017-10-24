package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaseAdapterTest {
  ICaseAdapter adapter;

  @Before
  public void before() {
    adapter = new CaseAdapter();
  }

  @Test
  public void testUpperToLower() {
    Assert.assertEquals("Hello World", adapter.adaptCase("HELLO World"));
  }

  @Test
  public void testLowerToUpper() {
    Assert.assertEquals("Hello World", adapter.adaptCase("hello world"));
  }
}
