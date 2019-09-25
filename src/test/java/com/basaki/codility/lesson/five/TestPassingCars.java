package com.basaki.codility.lesson.five;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPassingCars {

    @Test
    public void testSolution() {
        PassingCars soln = new PassingCars();

        assertEquals(5, soln.solution(new int[] {0, 1, 0, 1, 1}));
    }
}
