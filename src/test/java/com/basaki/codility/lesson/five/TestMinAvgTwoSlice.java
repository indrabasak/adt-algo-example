package com.basaki.codility.lesson.five;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMinAvgTwoSlice {

    @Test
    public void testSolution() {
        MinAvgTwoSlice soln = new MinAvgTwoSlice();
        assertEquals(1, soln.solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }

    @Test
    public void testSolutionOne() {
        MinAvgTwoSlice soln = new MinAvgTwoSlice();
        assertEquals(1, soln.solutionOne(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }
}
