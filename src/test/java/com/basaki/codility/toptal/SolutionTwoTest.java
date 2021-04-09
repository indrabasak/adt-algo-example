package com.basaki.codility.toptal;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class SolutionTwoTest {

    @Test
    public void testSolution() {
        SolutionTwo soln = new SolutionTwo();
        assertEquals("11001,10100", soln.solution(3, 2, new int[]{2, 1, 1, 0, 1}));
    }
}
