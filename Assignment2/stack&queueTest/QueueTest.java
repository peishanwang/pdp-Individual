package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by peishan on 2017/9/24.
 */
public class QueueTest {
  private IQueue testQueue = new MyQueue();
  @Before
  public void before() {
    testQueue = new MyQueue();
    int[] nums = new int[]{1, 8, 3, 8, 5, 9, 4, 2, 7};
    for (int num : nums) {
      testQueue = testQueue.enqueue(num);
    }
  }

  @Test
  public void testEmpty() {
    Assert.assertEquals(false, testQueue.isEmpty());
    for (int i = 0; i < 9; i++) {
      testQueue = testQueue.dequeue();
    }
    Assert.assertEquals(true, testQueue.isEmpty());
  }

  @Test
  public void testFront() {
    Assert.assertEquals(1, testQueue.front());
    testQueue = testQueue.dequeue();
    Assert.assertEquals(8, testQueue.front());
    testQueue = testQueue.dequeue();
    Assert.assertEquals(3, testQueue.front());
    testQueue = testQueue.enqueue(6);
    Assert.assertEquals(3, testQueue.front());
  }

  @Test
  public void testImmutable() {
    IQueue originalQueue = testQueue;
    Assert.assertEquals(1, testQueue.front());
    testQueue = testQueue.dequeue();
    Assert.assertEquals(8, testQueue.front());
    Assert.assertEquals(1, originalQueue.front());
  }
}
