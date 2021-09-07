package com.basaki.algodaily;

import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.FastMinimumInRotatedArray.getMinimum;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FastMinimumInRotatedArrayTest {

    @Test
    void minimumInSecondHalfTest() {
        assertEquals(getMinimum(new int[] { 6, 7, 8, 9, 10, 3, 4, 5 }), 3);
    }

    @Test
    void minimumInFirstHalfTest() {
        assertEquals(getMinimum(new int[] { 6, 7, 8, 0, 1, 2, 3, 4, 5 }), 0);
    }
}
