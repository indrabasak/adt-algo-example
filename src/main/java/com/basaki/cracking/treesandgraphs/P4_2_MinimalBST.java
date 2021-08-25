package com.basaki.cracking.treesandgraphs;

public class P4_2_MinimalBST {

    public static class TreeNode {
        private int value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode createMininimalBST(int[] array) {
        return createMininimalBST(array, 0, array.length - 1);
    }

    public TreeNode createMininimalBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = createMininimalBST(array, start, mid - 1);
        node.right = createMininimalBST(array, mid + 1, end);

        return node;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String... args) {
        int[] array = {1, 2, 3, 4, 5};
        P4_2_MinimalBST tree = new P4_2_MinimalBST();
        TreeNode node = tree.createMininimalBST(array);
        tree.inOrderTraversal(node);

        System.out.println("\n*** " + (0+1)/2);
    }
}
