package com.basaki.cracking.treesandgraphs;

import lombok.Data;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        } else {
            if (node.getValue() > value) {
                node.left = insert(node.getLeft(), value);
            } else if (node.getValue() < value) {
                node.right = insert(node.getRight(), value);
            }
        }

        return node;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode node, int value) {
        if (node == null) {
            throw new RuntimeException("cannot delete.");
        } else {
            if (node.getValue() > value) {
                node.left = delete(node.getLeft(), value);
            } else if (node.getValue() < value) {
                node.right = delete(node.getRight(), value);
            } else { // found the node
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    // get data from the rightmost node in the left subtree
                    node.value = retrieveData(node.left);
                    // delete the rightmost node in the left subtree
                    node.left = delete(node.left, node.value);
                }
            }
        }

        return node;
    }

    private int retrieveData(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }

        return node.value;
    }

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(TreeNode node, int value) {
        if (node == null) {
            return false;
        } else if (node.value == value) {
            return true;
        } else if (node.value > value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getValue() + " -> ");
            inOrderTraversal(node.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " -> ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.print(node.getValue() + " -> ");
        }
    }

    @Data
    public static class TreeNode {
        private int value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String... args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(18);
        tree.insert(2);
        tree.insert(7);
        tree.insert(21);

        System.out.print("in order traversal: ");
        tree.inOrderTraversal();

        System.out.print("pre order traversal: ");
        tree.preOrderTraversal();

        System.out.print("post order traversal: ");
        tree.postOrderTraversal();

        System.out.println("18 found: " + tree.search(18));
        tree.delete(18);
        System.out.print("in order traversal: ");
        tree.inOrderTraversal();
        System.out.println("18 found: " + tree.search(18));
        System.out.println("2 found: " + tree.search(2));
    }
}
