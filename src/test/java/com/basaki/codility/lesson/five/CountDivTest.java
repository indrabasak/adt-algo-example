package com.basaki.codility.lesson.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountDivTest {

    @Test
    void testSolution() {
        CountDiv soln = new CountDiv();
        assertEquals(3, soln.solution(6, 11, 2));
    }

    @Test
    void testSolutionOne() {
        CountDiv soln = new CountDiv();
        assertEquals(3, soln.solutionOne(6, 11, 2));
    }
}
