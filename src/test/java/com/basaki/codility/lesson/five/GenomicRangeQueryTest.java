package com.basaki.codility.lesson.five;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GenomicRangeQueryTest {

    @Test
    public void testSolution() {
        GenomicRangeQuery soln = new GenomicRangeQuery();

        assertArrayEquals(new int[]{2, 4, 1},
                          soln.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));

        assertArrayEquals(new int[]{4},
                          soln.solution("CAGCCTA", new int[]{5}, new int[]{5}));
    }

    @Test
    public void testSolutionOne() {
        GenomicRangeQuery soln = new GenomicRangeQuery();

        assertArrayEquals(new int[]{2, 4, 1},
                          soln.solutionOne("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }
}
