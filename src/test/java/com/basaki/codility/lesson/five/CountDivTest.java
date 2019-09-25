package com.basaki.codility.lesson.five;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDivTest {

    @Test
    public void testSolution() {
        CountDiv soln = new CountDiv();
        assertEquals(3, soln.solution(6, 11, 2));
    }

    @Test
    public void testSolutionOne() {
        CountDiv soln = new CountDiv();
        assertEquals(3, soln.solutionOne(6, 11, 2));
    }
}
