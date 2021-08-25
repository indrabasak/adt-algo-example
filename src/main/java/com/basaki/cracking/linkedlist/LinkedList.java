package com.basaki.cracking.linkedlist;

public class LinkedList {

    public LinkedListNode head;

    public void add(int data) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.data = data;

        if (head == null) {
            head = newNode;
            return;
        }

        LinkedListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    public static void print(LinkedListNode node) {
        LinkedListNode currentNode = node;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println(" NULL ");
    }
}
