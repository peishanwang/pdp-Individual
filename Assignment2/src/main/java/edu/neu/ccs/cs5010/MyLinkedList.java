package edu.neu.ccs.cs5010;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by peishan on 2017/9/26.
 */
public class MyLinkedList<E> extends LinkedList<E> implements List<E> {
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LinkedList) || (((LinkedList) obj).size() != this.size())) {
            return false;
        }
        LinkedList<E> expLinkedList = (LinkedList<E>) obj;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != expLinkedList.get(i)) {
                return false;
            }
        }
        return true;
    }
}
