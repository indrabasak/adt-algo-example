package com.basaki.cracking.linkedlist;

public class P2_5_SumLists {
    LinkedListNode head3 = null;
    LinkedListNode tail3 = null;


    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode head1 = l1;
        LinkedListNode head2 = l2;

        LinkedListNode head3 = null;
        LinkedListNode tail3 = null;
        int carryOver = 0;

        while (head1 != null && head2 != null) {
            int total = head1.data + head2.data + carryOver;
            int data = total % 10;
            carryOver = total / 10;
            LinkedListNode newNode = new LinkedListNode();
            newNode.data = data;
            if (head3 == null) {
                head3 = newNode;
                tail3 = newNode;
            } else {
                tail3.next = newNode;
                tail3 = newNode;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        LinkedListNode head = null;
        if (head1 != null) {
            head = head1;
        } else if (head2 != null) {
            head = head2;
        }
        while (head != null) {
            int total = head.data + carryOver;
            int data = total % 10;
            carryOver = total / 10;
            LinkedListNode newNode = new LinkedListNode();
            newNode.data = data;

            if (head3 == null) {
                head3 = newNode;
                tail3 = newNode;
            } else {
                tail3.next = newNode;
                tail3 = newNode;
            }

            head = head.next;
        }

        return head3;
    }

    public static void main(String... args) {
        LinkedList list1 = new LinkedList();
        list1.add(7);
        list1.add(1);
        list1.add(6);
        LinkedList.print(list1.head);

        LinkedList list2 = new LinkedList();
        list2.add(5);
        list2.add(9);
        list2.add(2);
        LinkedList.print(list2.head);

        LinkedList.print(addLists(list1.head, list2.head));
    }
}
