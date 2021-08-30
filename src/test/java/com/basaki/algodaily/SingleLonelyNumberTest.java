package com.basaki.algodaily;


import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.SingleLonelyNumber.lonelyNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleLonelyNumberTest {

    @Test
    void multipleNonLonelyTest() {
        assertEquals(lonelyNumber(new int[] {4, 4, 6, 1, 3, 1, 3}), 6);
    }

    @Test
    void oneNonLonelyTest() {
        assertEquals(lonelyNumber(new int[] {3, 3, 9}), 9);
    }

    @Test
    void singularArrayTest() {
        assertEquals(lonelyNumber(new int[] {1}), 1);
    }
}
