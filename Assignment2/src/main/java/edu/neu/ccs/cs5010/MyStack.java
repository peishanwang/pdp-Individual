package edu.neu.ccs.cs5010;

import java.util.Stack;

/**
 * Created by zontakm on 9/12/2017.
 * This is a dummy implementation of Stack ADT
 */
public class MyStack implements IStack {
    private Stack<Integer> stack;
    public MyStack() {
        stack = new Stack<>();
    }

    @Override
    public IStack push(int elt) {
        stack.push(elt);
        return this;
    }

    @Override
    public IStack pop() {
        stack.pop();
        return this;
    }

    @Override
    public int top() {
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }


}
