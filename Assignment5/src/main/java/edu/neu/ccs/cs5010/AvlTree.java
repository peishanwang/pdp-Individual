package edu.neu.ccs.cs5010;

public class AvlTree<T extends Comparable<? super T>> implements IAvlTree<T> {

  static class AvlNode<T> {
    T element;
    AvlNode<T> left;
    AvlNode<T> right;
    int height;

    /**
     * Constructor; creates a node without any children.
     * @param element The element contained in this node.
     */
    AvlNode(T element) {
      this(element, null, null);
    }

    /**
     * Constructor; creates a node with children.
     * @param element The element contained in this node.
     * @param left    Left child.
     * @param right   Right child.
     */
    AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
      this.element = element;
      this.left = left;
      this.right = right;
    }
  }

  private AvlNode<T> root;

  /**
   * Avl Tree Constructor.
   * Creates an empty tree
   */
  public AvlTree() {
    root = null;
  }

  /**
   * Determine the height of the given node.
   * @param node Node
   * @return Height of the given node.
   */
  private int height(AvlNode<T> node) {
    return node == null ? -1 : node.height;
  }

  /**
   * Find the maximum value among the given numbers.
   * @param num1 First number
   * @param num2 Second number
   * @return Maximum value
   */
  private int max(int num1, int num2) {
    if (num1 > num2) {
      return num1;
    }
    return num2;
  }

  @Override
  public boolean insert(T element) {
    try {
      root = insert(element, root);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Internal method to perform an actual insertion.
   * @param element Element to add
   * @param root    Root of the tree
   * @return New root of the tree
   * @throws Exception exception
   */
  private AvlNode<T> insert(T element, AvlNode<T> root) throws Exception {
    if (root == null) {
      root = new AvlNode<T>(element);
    } else if (element.compareTo(root.element) < 0) {
      root.left = insert(element, root.left);
      if (height(root.left) - height(root.right) == 2) {
        if (element.compareTo(root.left.element) < 0) {
          root = rotateWithLeftChild(root);
        } else {
          root = doubleWithLeftChild(root);
        }
      }
    } else if (element.compareTo(root.element) > 0) {
      root.right = insert(element, root.right);
      if (height(root.right) - height(root.left) == 2) {
        if (element.compareTo(root.right.element) > 0) {
          root = rotateWithRightChild(root);
        } else {
          root = doubleWithRightChild(root);
        }
      }
    } else {
      throw new Exception("Attempting to insert duplicate value");
    }

    root.height = max(height(root.left), height(root.right)) + 1;
    return root;
  }

  /**
   * Rotate binary tree node with left child.
   * For AVL trees, this is a single rotation for case 1.
   * Update heights, then return new root.
   *
   * @param node2 Root of tree we are rotating
   * @return New root
   */
  private AvlNode<T> rotateWithLeftChild(AvlNode<T> node2) {
    AvlNode<T> node1 = node2.left;

    node2.left = node1.right;
    node1.right = node2;

    node2.height = max(height(node2.left), height(node2.right)) + 1;
    node1.height = max(height(node1.left), node2.height) + 1;

    return (node1);
  }

  /**
   * Double rotate binary tree node: first left child
   * with its right child; then node k3 with new left child.
   * For AVL trees, this is a double rotation for case 2.
   * Update heights, then return new root.
   *
   * @param node3 Root of tree we are rotating
   * @return New root
   */
  private AvlNode<T> doubleWithLeftChild(AvlNode<T> node3) {
    node3.left = rotateWithRightChild(node3.left);
    return rotateWithLeftChild(node3);
  }

  /**
   * Rotate binary tree node with right child.
   * For AVL trees, this is a single rotation for case 4.
   * Update heights, then return new root.
   *
   * @param node1 Root of tree we are rotating.
   * @return New root
   */
  private AvlNode<T> rotateWithRightChild(AvlNode<T> node1) {
    AvlNode<T> node2 = node1.right;

    node1.right = node2.left;
    node2.left = node1;

    node1.height = max(height(node1.left), height(node1.right)) + 1;
    node2.height = max(height(node2.right), node1.height) + 1;

    return (node2);
  }

  /**
   * Double rotate binary tree node: first right child
   * with its left child; then node k1 with new right child.
   * For AVL trees, this is a double rotation for case 3.
   * Update heights, then return new root.
   *
   * @param node1 Root of tree we are rotating
   * @return New root
   */
  private AvlNode<T> doubleWithRightChild(AvlNode<T> node1) {
    node1.right = rotateWithLeftChild(node1.right);
    return rotateWithRightChild(node1);
  }

  @Override
  public boolean isEmpty() {
    return (root == null);
  }

  @Override
  public T findMin() {
    if (isEmpty()) {
      return null;
    }
    return findMin(root).element;
  }

  /**
   * Internal method to find the smallest item in a subtree.
   *
   * @param root the node that roots the tree.
   * @return node containing the smallest item.
   */
  private AvlNode<T> findMin(AvlNode<T> root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  @Override
  public T findMax() {
    if (isEmpty()) {
      return null;
    }
    return findMax(root).element;
  }

  /**
   * Internal method to find the largest item in a subtree.
   *
   * @param root the node that roots the tree.
   * @return node containing the largest item.
   */
  private AvlNode<T> findMax(AvlNode<T> root) {
    while (root.right != null) {
      root = root.right;
    }
    return root;
  }

  @Override
  public boolean remove(T element) {
    try {
      root = remove(element, root);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Remove from the tree. Nothing is done if element is not found.
   *
   * @param element the item to remove.
   * @param root    root of the tree.
   * @return True if remove successfully. False otherwise.
   */
  private AvlNode<T> remove(T element, AvlNode<T> root) throws Exception {
    if (root == null) {
      throw new Exception("The element is not in this tree");
    }

    int compareResult = element.compareTo(root.element);

    if (compareResult < 0) {
      root.left = remove(element, root.left);
    } else if (compareResult > 0) {
      root.right = remove(element, root.right);
    } else if (root.left != null && root.right != null) { // Two children
      root.element = findMin(root.right).element;
      root.right = remove(root.element, root.right);
    } else {
      root = (root.left != null) ? root.left : root.right;
    }
    return root;
  }

  @Override
  public boolean contains(T element) {
    return contains(element, root);
  }

  /**
   * Internal find method; search for an element starting at the given node.
   *
   * @param element Element to find
   * @param root    Root of the tree
   * @return True if the element is found, false otherwise
   */
  private boolean contains(T element, AvlNode<T> root) {
    if (root == null) {
      return false; // The node was not found

    } else if (element.compareTo(root.element) < 0) {
      return contains(element, root.left);
    } else if (element.compareTo(root.element) > 0) {
      return contains(element, root.right);
    }
    return true;
  }
}
