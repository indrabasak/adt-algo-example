package com.basaki.codility.lesson.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GenomicRangeQueryTest {

    @Test
    void testSolution() {
        GenomicRangeQuery soln = new GenomicRangeQuery();

        assertArrayEquals(new int[]{2, 4, 1},
                          soln.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));

        assertArrayEquals(new int[]{4},
                          soln.solution("CAGCCTA", new int[]{5}, new int[]{5}));
    }

    @Test
    void testSolutionOne() {
        GenomicRangeQuery soln = new GenomicRangeQuery();

        assertArrayEquals(new int[]{2, 4, 1},
                          soln.solutionOne("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }
}
