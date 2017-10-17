package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by peishan on 2017/9/24.
 */

public class StackTest {
  private IStack testStack;

  @Before
  public void before() {
    testStack = new MyStack();
    int[] nums = new int[]{1, 8, 3, 8, 5, 9, 4, 2, 7};
    for (int num : nums) {
      testStack = testStack.push(num);
    }
  }

  @Test
  public void testEmpty() {
    Assert.assertEquals(false, testStack.isEmpty());
    for (int i = 0; i < 9; i++) {
      testStack = testStack.pop();
    }
    Assert.assertEquals(true, testStack.isEmpty());
  }

  @Test
  public void testTop() {
    Assert.assertEquals(7, testStack.top());
    testStack = testStack.pop();
    Assert.assertEquals(2, testStack.top());
    testStack = testStack.push(6);
    Assert.assertEquals(6, testStack.top());
  }

  @Test
  public void testImmutable() {
    IStack originalStack = testStack;
    Assert.assertEquals(7, testStack.top());
    testStack = testStack.pop();
    Assert.assertEquals(2, testStack.top());
    Assert.assertEquals(7, originalStack.top());
  }

}
