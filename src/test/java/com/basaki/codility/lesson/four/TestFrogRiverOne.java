package com.basaki.codility.lesson.four;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFrogRiverOne {

    @Test
    public void testSolution() {
        FrogRiverOne soln = new FrogRiverOne();
        assertEquals(6, soln.solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
    }
}
