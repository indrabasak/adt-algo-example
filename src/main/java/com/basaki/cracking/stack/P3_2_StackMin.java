package com.basaki.cracking.stack;

import java.util.EmptyStackException;

/**
 * 3.3 Stack Min: Hoe would you design a stack which, in addition to push and pop,
 * has a function min which returns the minimum element?
 */
public class P3_2_StackMin {

    private class Node {
        private int value;
        private int min;
    }

    private Node[] stack;
    private int stackSize;
    private int currentPosition = 0;

    public P3_2_StackMin(int stackSize) {
        stack = new Node[stackSize];
        this.stackSize = stackSize;
    }

    public void push(int value) {
        if (currentPosition >= stackSize) {
            throw new RuntimeException("Stack is full");
        }

        Node node = new Node();
        node.value = value;
        node.min = value;
        if (currentPosition == 0) {
            node.min = value;
        } else if (stack[currentPosition - 1].min < value) {
            node.min = stack[currentPosition - 1].min;
        }
        stack[currentPosition] = node;
        currentPosition++;
    }

    public int pop() {
        if (currentPosition == 0) {
            throw new EmptyStackException();
        }

        Node node = stack[currentPosition - 1];
        stack[currentPosition - 1] = null;
        currentPosition--;

        return node.value;
    }

    public int peek() {
        if (currentPosition == 0) {
            throw new EmptyStackException();
        }

        Node node = stack[currentPosition - 1];

        return node.value;
    }

    public int min() {
        if (currentPosition == 0) {
            return Integer.MAX_VALUE;
        }

        Node node = stack[currentPosition - 1];
        return node.min;
    }

    public void print() {
        if (currentPosition == 0) {
            System.out.println("{}");
            return;
        }

        StringBuilder bldr = new StringBuilder();
        bldr.append("{ ");
        for (int i = 0; i < currentPosition; i++) {
            bldr.append(stack[i].value).append(" ");
        }
        bldr.append("} min is " + stack[currentPosition - 1].min);
        System.out.println(bldr.toString());
    }

    public static void main(String... args) {
        P3_2_StackMin ex = new P3_2_StackMin(10);
        ex.push(5);
        ex.print();
        ex.push(6);
        ex.print();
        ex.push(3);
        ex.print();
        ex.push(7);
        ex.print();
        ex.pop();
        ex.print();
        ex.pop();
        ex.print();
    }
}
