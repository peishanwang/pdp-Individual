package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by peishan on 2017/9/26.
 */

public class PriorityQueueTest {
  private IPriorityQueue<Integer> testPQ = new MyPriorityQueue<>();
  private List<Integer> myList = new ArrayList<>();

  @Test
  //test insert
  public void testInsert() {
    Integer[] nums = new Integer[]{1, 8, 3, 8, 5, 9, 4, 2, 7};
    for (Integer num : nums) {
      testPQ.insert(num);
    }
  }

  @Test
  //test getSize
  public void testSize() {
    Integer[] nums = new Integer[]{1, 8, 3, 8, 5};
    for (Integer num : nums) {
      testPQ.insert(num);
    }
    Assert.assertEquals(5, testPQ.getSize());
  }

  @Test
  //test getQueue
  public void testGetQueue() {
    Integer[] nums = new Integer[]{1, 8, 3, 8, 5, 9, 4, 2, 7};
    for (Integer num : nums) {
      testPQ.insert(num);
    }
    Assert.assertEquals(1, testPQ.getQueue()[0]);
    Assert.assertEquals(2, testPQ.getQueue()[1]);
    Assert.assertEquals(3, testPQ.getQueue()[2]);
  }

  @Test
  //test forward traversal
  public void testForward() {
    Integer[] nums = new Integer[]{1, 8, 3, 8, 5, 9, 4, 2, 7};
    for (Integer num : nums) {
      testPQ.insert(num);
      myList.add(num);
    }
    Collections.sort(myList);
    Assert.assertEquals(myList, testPQ.testForwardTraversal());
  }

  @Test
  //test reverse traversal
  public void testReverse() {
    Integer[] nums = new Integer[]{1, 8, 3, 8, 5, 9, 4, 2, 7};
    for (Integer num : nums) {
      testPQ.insert(num);
      myList.add(num);
    }
    Collections.sort(myList, (a, b) -> b - a);
    Assert.assertEquals(myList, testPQ.testReverseTraversal());
  }

  @Test
  //test remove
  public void testRemove() {
    Integer[] nums = new Integer[]{1, 8, 3, 8, 5, 9, 4, 7};
    for (Integer num : nums) {
      testPQ.insert(num);
    }
    Assert.assertEquals(new Integer(1), testPQ.remove());
    Assert.assertEquals(new Integer(3), testPQ.remove());
  }

  @Test
  //test front
  public void testFront() {
    Integer[] nums = new Integer[]{1, 8, 3, 8, 5, 9, 4, 2, 7};
    for (Integer num : nums) {
      testPQ.insert(num);
    }
    Assert.assertEquals(new Integer(1), testPQ.front());
    Assert.assertEquals(new Integer(1), testPQ.remove());
    Assert.assertEquals(new Integer(2), testPQ.front());
  }

  @Test
  //test isEmpty
  public void testEmpty() {
    Assert.assertEquals(true, testPQ.isEmpty());
    testPQ.insert(1);
    Assert.assertEquals(false, testPQ.isEmpty());
  }
}
