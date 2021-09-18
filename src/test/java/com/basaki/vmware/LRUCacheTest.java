package com.basaki.vmware;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LRUCacheTest {

    @Test
    void testRefer() {
        LRUCache cache = new LRUCache(3);
        cache.refer(3);
        cache.refer(2);
        cache.refer(1);

        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, cache.print());

        cache.refer(5);
        int[] expectedTwo = {5, 1, 2};
        assertArrayEquals(expectedTwo, cache.print());

        cache.refer(2);
        int[] expectedThree = {2, 5, 1};
        assertArrayEquals(expectedThree, cache.print());
    }
}
