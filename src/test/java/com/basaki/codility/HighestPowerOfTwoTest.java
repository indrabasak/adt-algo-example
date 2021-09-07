package com.basaki.codility;

import org.junit.jupiter.api.Test;

import static com.basaki.codility.HighestPowerOfTwo.findHighestPower;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestPowerOfTwoTest {

    @Test
    void testFindHighestPower() {
        assertEquals(3, findHighestPower(24));
    }
}
