package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;


/**
 * Created by peishan on 2017/9/24.
 */

public class StackTest {
    private IStack testStack = new MyStack();
    private List<Integer> list = new MyLinkedList();

    @Test
    public void testIStack() {
        //current testStack : empty
        Assert.assertEquals(true, testStack.isEmpty());
        int[] nums = new int[]{1, 8, 3, 8, 5, 9, 4, 2, 7};

        for (int num : nums) {
            pushInt(num);
        }
        //current testStack : 1, 8, 3, 8, 5, 9, 4, 2, 7
        Assert.assertEquals(false, testStack.isEmpty());
        Assert.assertEquals(7, testStack.top());
        Assert.assertEquals(list, myStackToList());
        //current testStack : empty
        Assert.assertEquals(true, testStack.isEmpty());
    }

    private List<Integer> myStackToList() {
        List<Integer> myList = new MyLinkedList();
        while (!testStack.isEmpty()) {
            myList.add(0, testStack.top());
            testStack.pop();
        }
        return myList;
    }

    private void pushInt(int num) {
        list.add(num);
        testStack.push(num);
    }
}
