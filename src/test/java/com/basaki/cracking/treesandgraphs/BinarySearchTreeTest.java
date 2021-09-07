package com.basaki.cracking.treesandgraphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {

    @Test
    void testInsertAndSearch() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(18);
        tree.insert(2);
        tree.insert(7);
        tree.insert(21);

        assertTrue(tree.search(2));
        assertFalse(tree.search(3));
    }
}
