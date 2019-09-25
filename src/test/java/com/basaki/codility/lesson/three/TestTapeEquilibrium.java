package com.basaki.codility.lesson.three;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTapeEquilibrium {

    @Test
    public void testSolution() {
        TapeEquilibrium soln = new TapeEquilibrium();
        assertEquals(1, soln.solution(new int[] {3, 1, 2, 4, 3}));
    }

    @Test
    public void testSolutionOne() {
        TapeEquilibrium soln = new TapeEquilibrium();
        assertEquals(1, soln.solutionOne(new int[] {3, 1, 2, 4, 3}));
    }
}
