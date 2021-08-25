package com.basaki.vmware;

public class SpiralOrderTraversalTree {


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void spiralOrderTraversal() {
        int height = height(root);

    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String... args) {
        SpiralOrderTraversalTree tree = new SpiralOrderTraversalTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
    }


}
