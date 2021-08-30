package com.basaki.codility.lesson.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermMissingElemTest {

    @Test
    void testSolution() {
       PermMissingElem soln = new PermMissingElem();
        assertEquals(1, soln.solution(null));
        assertEquals(1, soln.solution(new int[]{2}));
        assertEquals(4, soln.solution(new int[]{2, 3, 1, 5}));
        assertEquals(1, soln.solution(new int[]{2, 3, 5}));
    }
}
