package com.basaki.cracking.linkedlist;

public class P2_4_Partition {

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;

        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        LinkedListNode currentNode = node;
        while (currentNode != null) {
            if (currentNode.data < x) {
                if (beforeStart == null) {
                    beforeStart = currentNode;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = currentNode;
                    beforeEnd = currentNode;
                }
            } else {
                if (afterStart == null) {
                    afterStart = currentNode;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = currentNode;
                    afterEnd = currentNode;
                }
            }
            currentNode = currentNode.next;
        }

        // need to remove the previous next pointer
        // otherwise there will be a loop
        afterEnd.next = null;

        if (beforeStart == null) {
            return afterStart;
        }

        // merge two lists
        beforeEnd.next = afterStart;

        return beforeStart;
    }

    public static void main(String... args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(1);
        LinkedList.print(list.head);

        LinkedListNode node = partition(list.head, 5);
        LinkedList.print(node);
    }
}
