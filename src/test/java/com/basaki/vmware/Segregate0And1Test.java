package com.basaki.vmware;

import org.junit.jupiter.api.Test;

import static com.basaki.vmware.Segregate0And1.segregate;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Segregate0And1Test {

    @Test
    void testSegregate() {
        int[] arr = {0, 1, 0, 1, 1, 1};
        segregate(arr, arr.length);
        int[] expected = {0, 0, 1, 1, 1, 1};
        assertArrayEquals(expected, arr);
    }
}
