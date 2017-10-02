package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;


/**
 * Created by peishan on 2017/9/24.
 */
public class QueueTest {
    private IQueue testQueue = new MyQueue();
    private List<Integer> list = new MyLinkedList();

    @Test
    public void testIQueue() {
        //current testQueue : empty
        Assert.assertEquals(true, testQueue.isEmpty());
        int[] nums = new int[]{1, 8, 3, 8, 5, 9, 4, 2, 7};

        for (int num : nums) {
            addInt(num);
        }
        //current testQueue : 1, 8, 3, 8, 5, 9, 4, 2, 7
        Assert.assertEquals(false, testQueue.isEmpty());
        Assert.assertEquals(1, testQueue.front());
        Assert.assertEquals(list, myQueueToList());
        //current testQueue : empty
        Assert.assertEquals(true, testQueue.isEmpty());
    }

    private List<Integer> myQueueToList() {
        List<Integer> myList = new MyLinkedList();
        while (!testQueue.isEmpty()) {
            myList.add(testQueue.front());
            testQueue.dequeue();
        }
        return myList;
    }


    private void addInt(int num) {
        list.add(num);
        testQueue.enqueue(num);
    }
}
