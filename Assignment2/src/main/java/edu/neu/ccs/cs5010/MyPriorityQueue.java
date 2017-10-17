package edu.neu.ccs.cs5010;

import java.util.*;

/**
 * PriorityQueue.
 */
public class MyPriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
  private Object[] queue; // non-private to simplify nested class access
  private int size;
  private static final int DEFAULT_INITIAL_CAPACITY = 8;
  private final Comparator<? super E> comparator;

  public MyPriorityQueue() {
    this(DEFAULT_INITIAL_CAPACITY, null);
  }

  public MyPriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
    this.queue = new Object[initialCapacity];
    this.size = 0;
    this.comparator = comparator;
  }

  public MyPriorityQueue(Comparator<? super E> comparator) {
    this(DEFAULT_INITIAL_CAPACITY, comparator);
  }

  public MyPriorityQueue(MyPriorityQueue another) {
    this.queue = Arrays.copyOf(another.getQueue(), another.getSize());
    this.size = another.size;
    this.comparator = another.comparator;
  }

  @Override
  public void insert(E value) {
    //if (input == null) throw new NullPointerException();
    if (size == queue.length) {
      expandArray();
    }
    int index = size;
    if (index == 0) {
      queue[0] = value;
    } else {
      swim(value, index);
    }
    size++;
  }

  @Override
  public E remove() {
    size--;
    E front = (E) front(), tail = (E) queue[size];
    queue[size] = null;
    sink(tail);
    return front;
  }

  @Override
  public E front() {
    return (E) queue[0];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public List<E> testForwardTraversal() {
    List<E> forwardList = new LinkedList<>();
    MyPriorityQueue<E> copyPQ = new MyPriorityQueue(this);
    while (!copyPQ.isEmpty()) {
      forwardList.add(copyPQ.remove());
    }
    return forwardList;
  }

  @Override
  public List testReverseTraversal() {
    List<E> reverseList = new LinkedList<>();
    MyPriorityQueue<E> copyPQ = new MyPriorityQueue(this);
    while (!copyPQ.isEmpty()) {
      reverseList.add(0, copyPQ.remove());
    }
    return reverseList;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public Object[] getQueue() {
    return queue;
  }


  private void swim(E input, int index) {
    if (comparator != null) {
      swimUsingComparator(input, index);
    } else {
      swimUsingComparable(input, index);
    }
  }

  private void swimUsingComparable(E input, int index) {
    while (index > 0) {
      int parent = (index - 1) / 2;
      if (input.compareTo((E) queue[parent]) >= 0) {
        break;
      }
      queue[index] = queue[parent];
      index = parent;
    }
    queue[index] = input;
  }

  private void swimUsingComparator(E input, int index) {
    while (index > 0) {
      int parent = (index - 1) / 2;
      if (comparator.compare(input, (E) queue[parent]) >= 0) {
        break;
      }
      queue[index] = queue[parent];
      index = parent;
    }
    queue[index] = input;
  }

  private void sink(E value) {
    if (comparator != null) {
      sinkUsingComparator(value);
    } else {
      sinkUsingComparable(value);
    }
  }

  private void sinkUsingComparable(E value) {
    int half = size / 2, index = 0;
    while (index < half) {
      int child = 2 * index + 1, right = child + 1;
      if ((right < size) && ((E) queue[child]).compareTo((E) queue[right]) > 0) {
        child = right;
      }
      if (value.compareTo((E) queue[child]) <= 0) {
        break;
      }
      queue[index] = queue[child];
      index = child;
    }
    queue[index] = value;
  }

  private void sinkUsingComparator(E value) {
    int half = size / 2, index = 0;
    while (index < half) {
      int child = 2 * index + 1, right = child + 1;
      if ((right < size) && (comparator.compare((E) queue[child], (E) queue[right]) > 0)) {
        child = right;
      }
      if (comparator.compare(value, (E) queue[child]) <= 0) {
        break;
      }
      queue[index] = queue[child];
      index = child;
    }
    queue[index] = value;
  }


  private void expandArray() {
    int newCapacity = size * 2;
    queue = Arrays.copyOf(queue, newCapacity);
  }

  private void swap(int index1, int index2) {
    E temp = (E) queue[index1];
    queue[index1] = queue[index2];
    queue[index2] = temp;
  }
}
