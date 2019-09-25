package com.basaki.codility.lesson.four;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermCheckTest {

    @Test
    public void testSolution() {
        PermCheck soln = new PermCheck();
        assertEquals(1, soln.solution(new int[] {4, 1, 3, 2}));
        assertEquals(0, soln.solution(new int[] {4, 1, 3}));
        assertEquals(0, soln.solution(new int[] {3, 1, 3, 3}));
    }
}
