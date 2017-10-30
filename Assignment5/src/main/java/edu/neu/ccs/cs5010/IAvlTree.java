package edu.neu.ccs.cs5010;

public interface IAvlTree<T> {
  /**
   * Insert an element into the tree.
   *
   * @param element Element to insert into the tree
   * @return True - Success, the Element was added.
   *         False - Error, the element was a duplicate.
   */
  boolean insert(T element);

  /**
   * Remove from the tree. Nothing is done if element is not found.
   * @param element the item to remove.
   */
  boolean remove( T element );

  /**
   * Determine if the tree is empty.
   *
   * @return True if the tree is empty
   */
  boolean isEmpty();

  /**
   * Check whether the tree contains specific element.
   *
   * @param element value to be checked.
   * @return True if the tree contains x. False otherwise.
   */
  boolean contains(T element);

  /**
   * Find the smallest item in the tree.
   * @return smallest item or null if empty.
   */
  T findMin();

  /**
   * Find the largest item in the tree.
   * @return the largest item or null if empty.
   */
  T findMax();

}
