package com.basaki.algodaily;


import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.LongestSubstringWithNoDups.findLongest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithNoDupsTest {

    @Test
    void testOne() {
        assertEquals(findLongest("algodaily"), 7);
    }

    @Test
    void testTwo() {
        assertEquals(findLongest("thisisatest"), 5);
    }

    @Test
    void testThree() {
        assertEquals(findLongest("rosesarered"), 4);
    }
}
