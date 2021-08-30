package com.basaki.codility.toptal;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class SolutionTwoTest {

    @Test
    void testSolution() {
        SolutionTwo soln = new SolutionTwo();
        assertEquals("11001,10100", soln.solution(3, 2, new int[]{2, 1, 1, 0, 1}));
    }
}
