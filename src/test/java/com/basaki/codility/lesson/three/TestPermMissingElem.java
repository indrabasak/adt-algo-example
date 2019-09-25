package com.basaki.codility.lesson.three;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPermMissingElem {

    @Test
    public void testSolution() {
       PermMissingElem soln = new PermMissingElem();
        assertEquals(1, soln.solution(null));
        assertEquals(1, soln.solution(new int[]{2}));
        assertEquals(4, soln.solution(new int[]{2, 3, 1, 5}));
        assertEquals(1, soln.solution(new int[]{2, 3, 5}));
    }
}
