package edu.neu.ccs.cs5010;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zontakm on 9/12/2017.
 * This is a DUMMY implementation of Queue ADT
 */
public class MyQueue implements IQueue {
    private Queue<Integer> queue;
    public MyQueue() {
        queue = new LinkedList<>();
    }
    @Override
    public IQueue enqueue(int elt) {
        queue.offer(elt);
        return this;
    }

    @Override
    public IQueue dequeue() {
        queue.poll();
        return this;
    }

    @Override
    public int front() {
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty(); }
}
