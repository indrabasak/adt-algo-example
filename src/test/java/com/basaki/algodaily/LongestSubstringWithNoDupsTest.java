package com.basaki.algodaily;

import org.junit.Test;

import static com.basaki.algodaily.LongestSubstringWithNoDups.findLongest;
import static org.junit.Assert.assertEquals;

public class LongestSubstringWithNoDupsTest {

    @Test
    public void testOne() {
        assertEquals(findLongest("algodaily"), 7);
    }

    @Test
    public void testTwo() {
        assertEquals(findLongest("thisisatest"), 5);
    }

    @Test
    public void testThree() {
        assertEquals(findLongest("rosesarered"), 4);
    }
}
