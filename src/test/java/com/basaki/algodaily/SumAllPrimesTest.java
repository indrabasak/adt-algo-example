package com.basaki.algodaily;

import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.SumAllPrimes.sumOfPrimes;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumAllPrimesTest {

    @Test
    void sumOfPrimesForTwoTest() {
        assertEquals(2, sumOfPrimes(2), "sumOfPrimes(2) should equal 2");
    }

    @Test
    void sumOfPrimesForThirtyTest() {
        assertEquals(sumOfPrimes(30), 129, "sumOfPrimes(30) should equal 129");
    }

    @Test
    void sumOfPrimesForFiftyFiveTest() {
        assertEquals(sumOfPrimes(55), 381, "sumOfPrimes(55) should equal 381");
    }

}
