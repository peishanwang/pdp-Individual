package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * Created by peishan on 2017/9/26.
 */
public interface IPriorityQueue<E> {
    void insert(E input);
    E remove();
    E front();
    boolean isEmpty();
    List testForwardTraversal();
    List testReverseTraversal();

    int getSize();
    Object[] getQueue();
}
