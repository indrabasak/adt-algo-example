package com.basaki.codility.lesson.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinAvgTwoSliceTest {

    @Test
    void testSolution() {
        MinAvgTwoSlice soln = new MinAvgTwoSlice();
        assertEquals(1, soln.solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }

    @Test
    void testSolutionOne() {
        MinAvgTwoSlice soln = new MinAvgTwoSlice();
        assertEquals(1, soln.solutionOne(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }
}
