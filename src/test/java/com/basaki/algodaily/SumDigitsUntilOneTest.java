package com.basaki.algodaily;

import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.SumDigitsUntilOne.sumDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumDigitsUntilOneTest {

    @Test
    void firstTest() {
        assertEquals(sumDigits(1), 1);
    }

    @Test
    void secondTest() {
        assertEquals(sumDigits(49), 4);
    }

    @Test
    void thirdTest() {
        assertEquals(sumDigits(439230), 3);
    }
}
