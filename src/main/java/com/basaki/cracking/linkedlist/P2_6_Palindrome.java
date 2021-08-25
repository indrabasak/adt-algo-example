package com.basaki.cracking.linkedlist;

import java.util.Stack;

/**
 * 2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class P2_6_Palindrome {

    public static boolean isPalindromeStack(LinkedListNode node) {
        LinkedListNode currentNode = node;
        Stack<Integer> stack = new Stack<>();

        while (currentNode != null) {
            stack.push(currentNode.data);
            currentNode = currentNode.next;
        }

        currentNode = node;
        while (currentNode != null) {
            if (currentNode.data != stack.pop()) {
                return false;
            }
            currentNode = currentNode.next;
        }

        return true;
    }

    public static void main(String... args) {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(0);
        LinkedList.print(list.head);
        System.out.println(isPalindromeStack(list.head));

        list.add(5);
        LinkedList.print(list.head);
        System.out.println(isPalindromeStack(list.head));
    }
}
