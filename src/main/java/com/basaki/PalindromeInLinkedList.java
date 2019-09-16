package com.basaki;

import com.basaki.list.LinkedList;
import com.basaki.list.Node;

import java.util.Stack;

@SuppressWarnings({"squid:S106", "squid:S1149"})
public class PalindromeInLinkedList {

    public static boolean isPalindrome(Node<Character> head) {
        if (head == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Node<Character> curr = head;
        while (curr != null) {
            stack.add(curr.getData());
            curr = curr.getNext();
        }

        boolean palindrome = true;
        curr = head;
        while (curr != null) {
            Character ch = stack.pop();
            if (!ch.equals(curr.getData())) {
                palindrome = false;
                break;
            }
            curr = curr.getNext();
        }

        return palindrome;
    }

    public static boolean isPalindrome2(String str) {
        boolean palindrome = true;

        if (str == null) {
            return false;
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.add('r');
        list.add('a');
        list.add('d');
        list.add('a');
        list.add('r');
        System.out.println(isPalindrome(list.getHead()));
        list = new LinkedList<>();
        list.add('d');
        list.add('a');
        list.add('k');
        list.add('o');
        list.add('o');
        System.out.println(isPalindrome(list.getHead()));
        System.out.println(isPalindrome2("radar"));
        System.out.println(isPalindrome2("radarx"));
        System.out.println(isPalindrome2(null));
        System.out.println(isPalindrome2("raar"));
    }

}
