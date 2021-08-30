package com.basaki.codility.lesson.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingIntegerTest {

    @Test
    void testSolution() {
        MissingInteger soln = new MissingInteger();

        assertEquals(5, soln.solution(new int[] {1, 3, 6, 4, 1, 2}));
        assertEquals(4, soln.solution(new int[] {1, 2, 3}));
        assertEquals(1, soln.solution(new int[] {-1, -3}));
    }
}
