package com.basaki.algodaily;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 * Can you write a function to traverse a binary tree in-order, and print out
 * the value of each node as it passes?
 *
 *   4
 *    \
 *     5
 *    /
 *   6
 * The example would output [4, 6, 5] since there is no left child for 4,
 * and 6 is visited in-order before 5.
 */
public class BinaryTreeInorderTraversal {

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        inorderTraversal(root, list);

        return list;
    }

    private static void inorderTraversal(Node node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
        }
    }
}
