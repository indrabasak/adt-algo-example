package com.basaki.codility.lesson.two;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OddOccurrencesInArrayTest {

    @Test
    void testSolution() {
        OddOccurrencesInArray soln = new OddOccurrencesInArray();

        int[] A = {9, 3, 9, 3, 9, 7, 9};
        assertEquals(7, soln.solution(A));
    }
}
