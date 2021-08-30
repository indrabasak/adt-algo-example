package com.basaki.codility.lesson.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrogRiverOneTest {

    @Test
    void testSolution() {
        FrogRiverOne soln = new FrogRiverOne();
        assertEquals(6, soln.solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
    }
}
