package com.basaki.codility.lesson.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MaxCountersTest {

    @Test
    void testSolution() {
        MaxCounters soln = new MaxCounters();
        assertArrayEquals(new int[] {3, 2, 2, 4, 2},
                          soln.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }

    @Test
    void testSolutionOne() {
        MaxCounters soln = new MaxCounters();
        assertArrayEquals(new int[] {3, 2, 2, 4, 2},
                          soln.solutionOne(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
}
