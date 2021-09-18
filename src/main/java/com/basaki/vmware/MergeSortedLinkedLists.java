package com.basaki.vmware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge 2 sorted linked lists in reverse order without using extra space
 * and without reversing.
 */
public class MergeSortedLinkedLists {

    public static class Node {
        public int value;

        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node mergeLists(Node listOne, Node listTwo) {

        Node nodeOne = reverse(listOne);
        Node nodeTwo = reverse(listTwo);

        Node root = null;
        Node tail = null;

        while (nodeOne != null && nodeTwo != null) {
            if (nodeOne.value > nodeTwo.value) {
                Node next = nodeOne.next;
                if (root == null) {
                    root = nodeOne;
                    tail = root;
                } else {
                    tail.next = nodeOne;
                    tail = tail.next;
                }
                nodeOne = next;
            } else if (nodeOne.value < nodeTwo.value) {
                Node next = nodeTwo.next;
                if (root == null) {
                    root = nodeTwo;
                    tail = root;
                } else {
                    tail.next = nodeTwo;
                    tail = tail.next;
                }
                nodeTwo = next;
            } else {
                Node nextOne = nodeOne.next;
                Node nextTwo = nodeTwo.next;
                if (root == null) {
                    root = nodeOne;
                    tail = root;
                    tail.next = nodeTwo;
                    tail = tail.next;
                } else {
                    tail.next = nodeOne;
                    tail = tail.next;
                    tail.next = nodeTwo;
                    tail = tail.next;
                }

                nodeOne = nextOne;
                nodeTwo = nextTwo;

            }
        }

        if (nodeOne != null) {
            tail.next = nodeOne;
        } else if  (nodeTwo != null) {
            tail.next = nodeTwo;
        }


        return root;
    }

    public static Node reverse(Node node) {
        Node prev = null;
        Node current = node;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static int[] print(Node node) {
        List<Integer> values = new ArrayList<>();
        Node current = node;
        while (current != null) {
            //System.out.print(current.value + " ");
            values.add(current.value);
            current = current.next;
        }

        return values.stream().mapToInt(i->i).toArray();
    }

    public static void main(String... args) {
        Node nodeOne = new Node(1);
        nodeOne.next = new Node(2);
        nodeOne.next.next = new Node(3);
        System.out.println(Arrays.toString(print(nodeOne)));
        //print(reverse(node));

        Node nodeTwo = new Node(4);
        nodeTwo.next = new Node(5);
        nodeTwo.next.next = new Node(6);
        System.out.println(Arrays.toString(print(nodeOne)));

        System.out.println(Arrays.toString(print(mergeLists(nodeOne, nodeTwo))));
    }
}
