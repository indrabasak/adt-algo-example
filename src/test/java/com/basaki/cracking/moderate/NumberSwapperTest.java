package com.basaki.cracking.moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.basaki.cracking.moderate.NumberSwapper.swap;

class NumberSwapperTest {

    @Test
    void testSwap() {
        int a = 9;
        int b = 4;
        int[] x = {a, b};
        swap(x);
        assertEquals(b, x[0]);
        assertEquals(a, x[1]);
    }
}
