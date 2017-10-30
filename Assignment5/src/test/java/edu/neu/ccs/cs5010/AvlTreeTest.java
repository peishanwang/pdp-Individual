package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvlTreeTest {
  private IAvlTree<Integer> tree;

  @Before
  public void before() {
    tree = new AvlTree<>();
  }

  @Test
  public void testInsert() {
    Assert.assertEquals(true, tree.insert(1));
    Assert.assertEquals(true, tree.insert(4));
    Assert.assertEquals(true, tree.insert(2));
    Assert.assertEquals(true, tree.insert(6));
    Assert.assertEquals(false, tree.insert(1));
  }

  @Test
  public void testRemove() {
    tree.insert(16);
    tree.insert(24);
    tree.insert(36);
    tree.insert(19);
    tree.insert(44);
    tree.insert(28);
    tree.insert(61);
    tree.insert(74);
    tree.insert(83);
    tree.insert(64);
    tree.insert(52);
    tree.insert(65);
    tree.insert(86);
    tree.insert(93);
    tree.insert(88);
    Assert.assertEquals(true, tree.remove(88));
    Assert.assertEquals(true, tree.remove(19));
    Assert.assertEquals(true, tree.remove(16));
    Assert.assertEquals(true, tree.remove(28));
    Assert.assertEquals(true, tree.remove(24));
    Assert.assertEquals(true, tree.remove(36));
    Assert.assertEquals(true, tree.remove(52));
    Assert.assertEquals(true, tree.remove(93));
    Assert.assertEquals(true, tree.remove(86));
    Assert.assertEquals(true, tree.remove(83));
    Assert.assertEquals(false, tree.remove(52));
  }

  @Test
  public void testIsEmpty() {
    Assert.assertEquals(true, tree.isEmpty());
    tree.insert(4);
    Assert.assertEquals(false, tree.isEmpty());
  }

  @Test
  public void testContains() {
    tree.insert(1);
    tree.insert(4);
    Assert.assertEquals(true, tree.contains(4));
    Assert.assertEquals(false, tree.contains(2));
    Assert.assertEquals(true, tree.contains(1));
  }

  @Test
  public void testMin() {
    Assert.assertEquals(null, tree.findMin());
    tree.insert(1);
    tree.insert(7);
    tree.insert(2);
    tree.insert(9);
    tree.insert(5);
    Assert.assertEquals(new Integer(1), tree.findMin());
  }

  @Test
  public void testMax() {
    Assert.assertEquals(null, tree.findMax());
    tree.insert(3);
    tree.insert(2);
    tree.insert(1);
    tree.insert(9);
    tree.insert(4);
    Assert.assertEquals(new Integer(9), tree.findMax());
  }
}
