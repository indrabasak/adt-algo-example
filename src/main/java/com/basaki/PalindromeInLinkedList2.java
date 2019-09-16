package com.basaki;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"squid:S106", "squid:S1149"})
public class PalindromeInLinkedList2 {

    public static boolean isPalindrome(List<Character> list) {
        boolean ret = true;
        if (list == null || list.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
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
        LinkedList<Character> list = new LinkedList<>();
        System.out.println(isPalindrome(list));
        list.add('r');
        list.add('a');
        list.add('d');
        list.add('a');
        list.add('r');
        System.out.println(isPalindrome(list));
        list = new LinkedList<>();
        list.add('d');
        list.add('a');
        list.add('k');
        list.add('o');
        list.add('o');
        System.out.println(isPalindrome(list));

    }

}
