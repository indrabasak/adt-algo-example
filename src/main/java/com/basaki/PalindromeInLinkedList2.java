package com.basaki;

import java.util.LinkedList;
import java.util.Stack;

public class PalindromeInLinkedList2 {

    public static boolean isPalindrome(LinkedList<Character> list) {
        boolean ret = true;
        if (list == null || list.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for (Character c : list) {
            stack.push(c);
        }

        for (Character c1 : list) {
            Character c2 = stack.pop();
            if (!c1.equals(c2)) {
                ret = false;
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<Character>();
        System.out.println(isPalindrome(list));
        list.add('r');
        list.add('a');
        list.add('d');
        list.add('a');
        list.add('r');
        System.out.println(isPalindrome(list));
        list = new LinkedList<Character>();
        list.add('d');
        list.add('a');
        list.add('k');
        list.add('o');
        list.add('o');
        System.out.println(isPalindrome(list));

    }

}
