package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;
import java.util.Collections;
import java.util.List;

/**
 * Created by peishan on 2017/9/26.
 */
public class PriorityQueueTest {
    private IPriorityQueue<Integer> testPQ = new MyPriorityQueue<>();
    private List<Integer> myList = new MyLinkedList();

    @Test
    public void testIPQ() {
        //test insert
        Integer[] nums = new Integer[]{1, 8, 3, 8, 5, 9, 4, 2, 7};
        for (Integer num : nums) {
            testPQ.insert(num);
            myList.add(num);
        }
        //test forward traversal
        Collections.sort(myList);
        Assert.assertEquals(myList, testPQ.testForwardTraversal());

        //test reverse traversal
        Collections.sort(myList, (a, b) -> b - a);
        Assert.assertEquals(myList, testPQ.testReverseTraversal());

        //test remove
        Assert.assertEquals(new Integer(1), testPQ.remove());
        Assert.assertEquals(new Integer(2), testPQ.remove());

        //test front
        Assert.assertEquals(new Integer(3), testPQ.front());
        Assert.assertEquals(new Integer(3), testPQ.remove());
        Assert.assertEquals(new Integer(4), testPQ.front());

    }
}
