package com.basaki.algodaily;

import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.MissingNumberInUnsorted.missingInUnsorted;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingNumberInUnsortedTest {

    @Test
    void testMissingInUnsorted() {
        assertEquals(8, missingInUnsorted(new int[] { 2, 5, 1, 4, 9, 6, 3, 7 }, 1, 9));
    }
}
