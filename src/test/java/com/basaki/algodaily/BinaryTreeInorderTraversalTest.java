package com.basaki.algodaily;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import static com.basaki.algodaily.BinaryTreeInorderTraversal.inorderTraversal;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BinaryTreeInorderTraversalTest {

    private BinaryTreeInorderTraversal.Node tree1;
    private BinaryTreeInorderTraversal.Node tree2;
    private BinaryTreeInorderTraversal.Node tree3;
    private BinaryTreeInorderTraversal.Node tree4;
    private BinaryTreeInorderTraversal.Node tree5;

    public static boolean bstDeepEquals(BinaryTreeInorderTraversal.Node a,
                                        BinaryTreeInorderTraversal.Node b) {
        if (a != null && b != null) {
            if (a.val == b.val) {
                return
                        bstDeepEquals(a.left, b.left) &&
                                bstDeepEquals(a.right, b.right);
            }
        }
        return a == null && b == null;
    }

    @Before
    public void setUp() {
        // Regular binary trees
        tree1 = new BinaryTreeInorderTraversal.Node(4);
        tree1.left = new BinaryTreeInorderTraversal.Node(1);
        tree1.right = new BinaryTreeInorderTraversal.Node(3);

        tree2 = new BinaryTreeInorderTraversal.Node(5);
        tree2.left = new BinaryTreeInorderTraversal.Node(10);
        tree2.left.left = new BinaryTreeInorderTraversal.Node(17);
        tree2.left.right = new BinaryTreeInorderTraversal.Node(3);
        tree2.right = new BinaryTreeInorderTraversal.Node(8);

        // Binary search trees
        tree3 = new BinaryTreeInorderTraversal.Node(6);
        tree3.left = new BinaryTreeInorderTraversal.Node(3);

        tree4 = new BinaryTreeInorderTraversal.Node(5);
        tree4.left = new BinaryTreeInorderTraversal.Node(3);
        tree4.left.left = new BinaryTreeInorderTraversal.Node(2);
        tree4.left.left.left = new BinaryTreeInorderTraversal.Node(1);

        tree5 = new BinaryTreeInorderTraversal.Node(8);
        tree5.left = new BinaryTreeInorderTraversal.Node(6);
        tree5.right = new BinaryTreeInorderTraversal.Node(9);
        tree5.left.left = new BinaryTreeInorderTraversal.Node(5);
        tree5.left.right = new BinaryTreeInorderTraversal.Node(7);
        tree5.right.right = new BinaryTreeInorderTraversal.Node(10);
    }

    @Test
    public void tinyTreeInorderTraversalTest() {
        assertIterableEquals(inorderTraversal(tree3), Arrays.asList(3, 6));
    }

    public void mediumSizedTreeInorderTraversalTest() {
        assertIterableEquals(inorderTraversal(tree2), Arrays.asList(17, 10, 3, 5, 8));
    }
}
