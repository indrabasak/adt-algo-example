package com.basaki.codility.lesson.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrogJmpTest {

    @Test
    void testSolution() {
        FrogJmp soln = new FrogJmp();
        assertEquals(0, soln.solution(10, 5, 30));
        assertEquals(0, soln.solution(10, 10, 30));
        assertEquals(0, soln.solution(10, 10, -30));
        assertEquals(3, soln.solution(10, 85, 30));
    }
}
