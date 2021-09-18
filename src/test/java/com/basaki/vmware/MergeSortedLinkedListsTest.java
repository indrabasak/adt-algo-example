package com.basaki.vmware;

import org.junit.jupiter.api.Test;

import static com.basaki.vmware.MergeSortedLinkedLists.mergeLists;
import static com.basaki.vmware.MergeSortedLinkedLists.print;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedLinkedListsTest {

    @Test
    void testOne() {
        MergeSortedLinkedLists.Node nodeOne = new MergeSortedLinkedLists.Node(1);
        nodeOne.next = new MergeSortedLinkedLists.Node(2);
        nodeOne.next.next = new MergeSortedLinkedLists.Node(3);

        MergeSortedLinkedLists.Node nodeTwo = new MergeSortedLinkedLists.Node(4);
        nodeTwo.next = new MergeSortedLinkedLists.Node(5);
        nodeTwo.next.next = new MergeSortedLinkedLists.Node(6);

        int[] expected = {6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, print(mergeLists(nodeOne, nodeTwo)));
    }

    @Test
    void testTwo() {
        MergeSortedLinkedLists.Node nodeOne = new MergeSortedLinkedLists.Node(1);
        nodeOne.next = new MergeSortedLinkedLists.Node(2);
        nodeOne.next.next = new MergeSortedLinkedLists.Node(3);

        MergeSortedLinkedLists.Node nodeTwo = new MergeSortedLinkedLists.Node(4);
        nodeTwo.next = new MergeSortedLinkedLists.Node(5);
        nodeTwo.next.next = new MergeSortedLinkedLists.Node(6);
        nodeTwo.next.next.next = new MergeSortedLinkedLists.Node(8);


        int[] expected = {8, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, print(mergeLists(nodeOne, nodeTwo)));
    }

    @Test
    void testThree() {
        MergeSortedLinkedLists.Node nodeOne = new MergeSortedLinkedLists.Node(1);
        nodeOne.next = new MergeSortedLinkedLists.Node(2);
        nodeOne.next.next = new MergeSortedLinkedLists.Node(3);

        MergeSortedLinkedLists.Node nodeTwo = new MergeSortedLinkedLists.Node(3);
        nodeTwo.next = new MergeSortedLinkedLists.Node(5);
        nodeTwo.next.next = new MergeSortedLinkedLists.Node(6);
        nodeTwo.next.next.next = new MergeSortedLinkedLists.Node(8);


        int[] expected = {8, 6, 5, 3, 3, 2, 1};
        assertArrayEquals(expected, print(mergeLists(nodeOne, nodeTwo)));
    }
}
