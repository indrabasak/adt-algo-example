package com.basaki.codility.lesson.four;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMissingInteger {

    @Test
    public void testSolution() {
        MissingInteger soln = new MissingInteger();

        assertEquals(5, soln.solution(new int[] {1, 3, 6, 4, 1, 2}));
        assertEquals(4, soln.solution(new int[] {1, 2, 3}));
        assertEquals(1, soln.solution(new int[] {-1, -3}));
    }
}
