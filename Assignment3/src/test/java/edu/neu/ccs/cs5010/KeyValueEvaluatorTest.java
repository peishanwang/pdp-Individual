package edu.neu.ccs.cs5010;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KeyValueEvaluatorTest {

  @Test(expected = IllegalArgumentException.class)
  public void expectedExceptionTest() {
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    list1.add("haha1");
    list1.add("haha2");
    list2.add("hahaha1");
    KeyValueEvaluator kve = new KeyValueEvaluator(list1, list2);
  }
}
