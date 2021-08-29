package com.basaki.algodaily;

import org.junit.Test;

import static com.basaki.algodaily.SingleLonelyNumber.lonelyNumber;
import static org.junit.Assert.assertEquals;

public class SingleLonelyNumberTest {

    @Test
    public void multipleNonLonelyTest() {
        assertEquals(lonelyNumber(new int[] {4, 4, 6, 1, 3, 1, 3}), 6);
    }

    @Test
    public void oneNonLonelyTest() {
        assertEquals(lonelyNumber(new int[] {3, 3, 9}), 9);
    }

    @Test
    public void singularArrayTest() {
        assertEquals(lonelyNumber(new int[] {1}), 1);
    }
}
