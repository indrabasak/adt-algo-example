package com.basaki.cracking.stack;

import java.util.Stack;

/**
 * 3.5 Sort Stack: Write a program to sort a stack that the smallest items are
 * on the top. You can use an additional temporary stack but you may not copy
 * the elements into any other data structure (such as an array).
 */
public class P3_5_SortStack {

    private Stack<Integer> sortedStack = new Stack<>();

    public void push(int value) {
        sortedStack.push(value);
        sort();
    }

    public int peek() {
        return sortedStack.peek();
    }

    public int pop() {
        return sortedStack.pop();
    }

    private void sort() {
        Stack<Integer> r = new Stack<>();
        // insert element in sortedStack in sorted order in r
        while (!sortedStack.isEmpty()) {
            int tmp = sortedStack.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                sortedStack.push(r.pop());
            }
            r.push(tmp);
        }

        while (!r.isEmpty()) {
            sortedStack.push(r.pop());
        }
    }

    public static void main(String... args) {
        P3_5_SortStack ex = new P3_5_SortStack();
        ex.push(4);
        ex.push(5);
        System.out.println(ex.peek());

        ex.push(6);
        System.out.println(ex.peek());

        ex.push(7);
        System.out.println(ex.peek());

        System.out.println("pop: " + ex.pop());
        System.out.println("pop: " + ex.pop());
        System.out.println("pop: " + ex.pop());
        System.out.println("pop: " + ex.pop());
    }
}
