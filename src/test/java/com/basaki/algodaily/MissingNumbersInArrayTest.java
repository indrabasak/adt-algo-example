package com.basaki.algodaily;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.MissingNumbersInArray.missingNumbers;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class MissingNumbersInArrayTest {

    @Test
    void moreNumbersMissingThanNotTest() {
        assertIterableEquals(missingNumbers(new int[] { 3, 7, 9, 19 }),
                Arrays.asList(4, 5, 6, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18));
    }

    @Test
    void onlyOneMissingTest() {
        assertIterableEquals(missingNumbers(new int[] { 0, 1, 3 }), Arrays.asList(2));
    }

    @Test
    void multipleMissingTest() {
        assertIterableEquals(missingNumbers(new int[] { 10, 11, 14, 17 }), Arrays.asList(12, 13, 15, 16));
    }
}
