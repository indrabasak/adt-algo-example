package com.basaki.codility.lesson.three;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TapeEquilibriumTest {

    @Test
    void testSolution() {
        TapeEquilibrium soln = new TapeEquilibrium();
        assertEquals(1, soln.solution(new int[] {3, 1, 2, 4, 3}));
    }

    @Test
    void testSolutionOne() {
        TapeEquilibrium soln = new TapeEquilibrium();
        assertEquals(1, soln.solutionOne(new int[] {3, 1, 2, 4, 3}));
    }
}
