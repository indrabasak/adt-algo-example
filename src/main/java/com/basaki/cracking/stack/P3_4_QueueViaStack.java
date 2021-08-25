package com.basaki.cracking.stack;

import java.util.Stack;

/**
 * 3.4 Queue via Stacks: Implement a MyQueue class which implements queque
 * using two stacks.
 */
public class P3_4_QueueViaStack {

    private Stack<Integer> newStack = new Stack<>();

    private Stack<Integer> oldStack = new Stack<>();

    public void add(int value) {
        newStack.push(value);
    }

    public int remove() {
        if (oldStack.isEmpty()) {
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
        }

        return oldStack.pop();
    }

    public int peek() {
        if (oldStack.isEmpty()) {
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
        }
         return oldStack.peek();
    }

    public static void main(String[] args) {
        P3_4_QueueViaStack ex = new P3_4_QueueViaStack();
        ex.add(4);
        ex.add(5);
        System.out.println(ex.peek());

        ex.add(6);
        System.out.println(ex.peek());

        ex.add(7);
        System.out.println(ex.remove());
        System.out.println(ex.peek());
        System.out.println(ex.remove());
        System.out.println(ex.peek());
        System.out.println(ex.remove());
        System.out.println(ex.peek());

    }
}
