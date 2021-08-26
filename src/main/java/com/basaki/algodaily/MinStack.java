package com.basaki.algodaily;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Recall that a stack is an abstract data type modeling a collection elements.
 * Its primary operations are push (which adds an element to the top of
 * the stack) and pop (which removes the most newest element).
 *
 * However, let's say we wanted to implement a stack with the following
 * interface, requiring the following methods to be defined:
 *
 * push(val) - add an element on to the top of the stack.
 *
 * pop(val) - remove the element at the top of the stack and return it.
 *
 * peek(val) - see the element at the top of the stack without removing it.
 *
 * min() - get minimum element in stack.
 *
 * How would you do it, and can you implement it via a MinStack class?
 *
 * Can you do call min() and retrieve it in O(1) time?
 *
 * Constraints
 * Total number of operations in the stack <= 100000
 * The values will be in the range -1000000000 and 1000000000
 * Expected time complexity : O(1)
 * Expected space complexity : O(n)
 */
public class MinStack {

    private Stack<Plate> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        Plate newPlate = new Plate();
        newPlate.val = val;
        newPlate.min = val;

        if (!stack.empty()) {
            Plate plate = stack.peek();
            if (val > plate.min) {
                newPlate.min = plate.min;
            }
        }

        stack.push(newPlate);
    }

    public int pop() {
        return stack.pop().val;
    }

    public int peek() {
        return stack.peek().val;
    }

    public int min() {
        return stack.peek().min;
    }

    private static class Plate {
        private int val;
        private int min;
    }

    public static void main(String... args) {
        MinStack minstack = new MinStack();
        minstack.push(4);
        minstack.push(7);
        minstack.push(3);
        minstack.push(2);
        minstack.push(6);
        int min1 = minstack.min();
        minstack.pop();
        int min2 = minstack.min();
        minstack.pop();
        int min3 = minstack.min();
        minstack.pop();
        int min4 = minstack.min();
        minstack.pop();
        assertEquals(min1, 2);
        assertEquals(min2, 2);
        assertEquals(min3, 3);
        assertEquals(min4, 4);
    }
}
