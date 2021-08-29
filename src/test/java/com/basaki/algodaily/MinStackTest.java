package com.basaki.algodaily;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinStackTest {

    @Test
    public void testMin() {
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
