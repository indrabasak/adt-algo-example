package com.basaki.algodaily;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.RemoveDuplicatesFromArray.uniques;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class RemoveDuplicatesFromArrayTest {

    @Test
    void hugeArrayWithFewDuplicationsTest() {
        assertIterableEquals(uniques(new int[] {8,8,15,6,19,7,12,6,6,3,13,9,15,14,1,13,4,11,16}),
                Arrays.asList(8,15,6,19,7,12,3,13,9,14,1,4,11,16));
    }

    @Test
    void mediumArrayWithMultipleDuplicationsTest() {
        assertIterableEquals(uniques(new int[] {5,10,3,17,9,12,19,4,16,19,7,9,7,8,10}),
                Arrays.asList(5,10,3,17,9,12,19,4,16,7,8));
    }

    @Test
    void hugeArrayWithSeveralDuplicationsTest() {
        assertIterableEquals(uniques(new int[] {9,0,11,16,19,14,7,18,10,6,0,17,12,9,12,18,0,14,17}),
                Arrays.asList(9,0,11,16,19,14,7,18,10,6,17,12));
    }

    @Test
    void lostOfDuplicationsTest() {
        assertIterableEquals(uniques(new int[] {12,7,2,20,20,2,15,20,2,10,12,1}),
                Arrays.asList(12,7,2,20,15,10,1));
    }

    @Test
    void mediumArrayWithFewDuplicationsTest() {
        assertIterableEquals(uniques(new int[] {6,12,5,1,4,18,10,17,10,0,1,7,6,18,11,2,15,19}),
                Arrays.asList(6,12,5,1,4,18,10,17,0,7,11,2,15,19));
    }
}
