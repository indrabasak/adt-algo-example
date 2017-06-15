package com.basaki.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The <code>BST</code>
 *
 * @author Indra Basak
 * @copyright 2014 CA Technologies. All rights reserved.
 */
public class BST<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> fRoot;

    /**
     *
     */
    public BST() {
    }

    public static void main(String[] args) {
        Integer[] a =
                {1, 5, 2, 7, 4};
        BST<Integer> bst = new BST<Integer>();
        for (Integer n : a)
            bst.insert(n);

        bst.preOrderTraversal();
        System.out.println();

        // testing comparator
        // build a mirror BST with a rule: Left > Parent > Right
        // code for the comparator at the bottom of the file
        // bst = new BST<Integer>(new MyComp1());
        for (Integer n : a)
            bst.insert(n);

        bst.preOrderTraversal();
        System.out.println();
        bst.inOrderTraversal();
        System.out.println();

        for (Integer n : bst)
            System.out.print(n);
        System.out.println();

        System.out.println(bst);

        // testing restoring a tree from two given traversals
        // bst.restore(new Integer[] {11,8,6,4,7,10,19,43,31,29,37,49},
        // new Integer[] {4,6,7,8,10,11,19,29,31,37,43,49});
        System.out.println("\n_________________________________ Preorder");
        bst.preOrderTraversal();
        System.out.println();
        System.out.println("\n_________________________________ Inorder");
        bst.inOrderTraversal();
        System.out.println("\n_________________________________");
        bst.printLevelOrderTraversal();
        System.out.println("\n_________________________________");
        bst.printPreOrderTraversal();
        System.out.println("\n_________________________________");
        bst.printInOrderTraversal();
        System.out.println("\n_________________________________");

        // testing diameter
        System.out.println("diameter = " + bst.diameter());
        // testing width
        System.out.println("width = " + bst.width());
    }

    public void insert(T data) {
        fRoot = insert(fRoot, data);
    }

    private Node<T> insert(Node<T> node, T toInsert) {
        if (node == null) {
            return new Node<T>(toInsert);
        } else if (compare(toInsert, node.data) == 0) {
            return node;
        } else if (compare(toInsert, node.data) < 0) {
            node.left = insert(node.left, toInsert);
        } else {
            node.right = insert(node.right, toInsert);
        }

        return node;
    }

    public boolean search(T toSearch) {
        return search(fRoot, toSearch);
    }

    private boolean search(Node<T> node, T toSearch) {
        if (node == null) {
            return false;
        } else if (compare(toSearch, node.data) == 0) {
            return true;
        } else if (compare(toSearch, node.data) < 0) {
            return search(node.left, toSearch);
        } else {
            return search(node.right, toSearch);
        }
    }

    public void delete(T toDelete) {
        fRoot = delete(fRoot, toDelete);
    }

    private Node<T> delete(Node<T> node, T toDelete) {
        if (node == null) {
            throw new RuntimeException("cannot delete.");
        } else if (compare(toDelete, node.data) < 0) {
            node.left = delete(node.left, toDelete);
        } else if (compare(toDelete, node.data) > 0) {
            node.right = delete(node.right, toDelete);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // get data from the rightmost node in the left subtree
                node.data = retrieveData(node.left);
                // delete the rightmost node in the left subtree
                node.left = delete(node.left, node.data);
            }
        }
        return node;
    }

    private T retrieveData(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }

        return node.data;
    }

    private int compare(T x, T y) {
        return x.compareTo(y);
    }

    public void preOrderTraversal() {
        preOrderTraversal(fRoot);
    }

    private void preOrderTraversal(Node<T> r) {
        if (r != null) {
            System.out.print(r + " ");
            preOrderTraversal(r.left);
            preOrderTraversal(r.right);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(fRoot);
    }

    private void inOrderTraversal(Node<T> r) {
        if (r != null) {
            inOrderTraversal(r.left);
            System.out.print(r + " ");
            inOrderTraversal(r.right);
        }
    }

    /**
     * Level Order Traversal (Breadth First Search) where we visit every node on
     * a level before going to a lower level.
     */
    public void printLevelOrderTraversal() {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(fRoot);
        while (!queue.isEmpty()) {
            Node<T> x = queue.remove();
            if (x != null) {
                System.out.print(x.data + " --> ");
            }
            if (x == null)
                continue;
            // keys.enqueue(x.key);
            queue.add(x.left);
            queue.add(x.right);
        }
    }

    public void printPreOrderTraversal() {
        Stack<Node<T>> stack = new Stack<Node<T>>();
        stack.push(fRoot);
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (current == null) {
                continue;
            }

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current != null) {
                System.out.print(current.data + " --> ");
            }
        }
    }

    //traverses node in ascending order
    public void printInOrderTraversal() {
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> current = fRoot;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.data + " --> ");
                current = current.right;
            }
        }
    }

    public int height() {
        return height(fRoot);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public int countLeaves() {
        return countLeaves(fRoot);
    }

    private int countLeaves(Node<T> node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

    // The width of a binary tree is the maximum number of elements on one level
    // of the tree.
    public int width() {
        int max = 0;
        for (int k = 0; k <= height(); k++) {
            int tmp = width(fRoot, k);
            if (tmp > max)
                max = tmp;
        }
        return max;
    }

    // rerturns the number of node on a given level
    public int width(Node<T> p, int depth) {
        if (p == null)
            return 0;
        else if (depth == 0)
            return 1;
        else
            return width(p.left, depth - 1) + width(p.right, depth - 1);
    }

    // The diameter of a tree is the number of nodes
    // on the longest path between two leaves in the tree.
    public int diameter() {
        return diameter(fRoot);
    }

    private int diameter(Node<T> p) {
        if (p == null)
            return 0;

        // the path goes through the root
        int len1 = height(p.left) + height(p.right) + 3;

        // the path does not pass the root
        int len2 = Math.max(diameter(p.left), diameter(p.right));

        return Math.max(len1, len2);
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        Stack<Node<T>> stk = new Stack<Node<T>>();

        public MyIterator() {
            if (fRoot != null) {
                stk.push(fRoot);
            }
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }

        public T next() {
            Node<T> cur = stk.peek();
            if (cur.left != null) {
                stk.push(cur.left);
            } else {
                Node<T> tmp = stk.pop();
                while (tmp.right == null) {
                    if (stk.isEmpty()) {
                        return cur.data;
                    }
                    tmp = stk.pop();
                }
                stk.push(tmp.right);
            }

            return cur.data;
        }// end of next()

        public void remove() {

        }
    }

    @SuppressWarnings("hiding")
    private class Node<T> {
        private T data;

        private Node<T> left, right;

        public Node(T data, Node<T> l, Node<T> r) {
            left = l;
            right = r;
            this.data = data;
        }

        public Node(T data) {
            this(data, null, null);
        }

        public String toString() {
            return data.toString();
        }
    }
}
