package com.basaki.vmware;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void reverseWithStack() {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        Node current = head;
        while (current.next != null) {
            current = current.next;
            stack.push(current);
        }

        head = stack.pop();
        current = head;
        while (!stack.empty()) {
            Node node = stack.pop();
            current.next = node;
            current = current.next;
        }
        current.next = null;
    }

    public void reverse() {
        if (head == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;
//
//        while (current != null) {
//            prev = current.next;
//        }

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    public Integer[] getNodes() {
        List<Integer> list = new ArrayList<>();

        Node current = head;
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }

        return list.toArray(new Integer[0]);
    }
}
