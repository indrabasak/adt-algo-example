package com.basaki.codility.lesson.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOddOccurrencesInArray {

    @Test
    public void testSolution() {
        OddOccurrencesInArray soln = new OddOccurrencesInArray();

        int[] A = {9, 3, 9, 3, 9, 7, 9};
        assertEquals(7, soln.solution(A));
    }
}
