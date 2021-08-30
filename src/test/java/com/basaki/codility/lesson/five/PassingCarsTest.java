package com.basaki.codility.lesson.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassingCarsTest {

    @Test
    void testSolution() {
        PassingCars soln = new PassingCars();
        assertEquals(5, soln.solution(new int[] {0, 1, 0, 1, 1}));
    }
}
