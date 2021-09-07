package com.basaki.vmware;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ReverseLinkedListTest {

    @Test
    void reverseWithStack() {
        ReverseLinkedList list = new ReverseLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        Integer[] nodes = list.getNodes();
        System.out.println(Arrays.toString(nodes));
        list.reverseWithStack();
        nodes = list.getNodes();
        System.out.println(Arrays.toString(nodes));

        Integer[] reverseNodes = {4, 3, 2, 1};
        assertArrayEquals(reverseNodes, nodes);
    }
}
