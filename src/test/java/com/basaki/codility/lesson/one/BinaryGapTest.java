package com.basaki.codility.lesson.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryGapTest {

    @Test
    void testSolution() {
        BinaryGap solution = new BinaryGap();

        int binaryGap = solution.solution(9);
        assertEquals(2, binaryGap);

        binaryGap = solution.solution(0);
        assertEquals(0, binaryGap);

        binaryGap = solution.solution(529);
        assertEquals(4, binaryGap);

        binaryGap = solution.solution(20);
        assertEquals(1, binaryGap);

        binaryGap = solution.solution(15);
        assertEquals(0, binaryGap);

        binaryGap = solution.solution(32);
        assertEquals(0, binaryGap);

        binaryGap = solution.solution(1041);
        assertEquals(5, binaryGap);

        binaryGap = solution.solution(32);
        assertEquals(0, binaryGap);

        binaryGap = solution.solution(Integer.MAX_VALUE);
        assertEquals(0, binaryGap);

        binaryGap = solution.solution(561892);
        assertEquals(3, binaryGap);

        binaryGap = solution.solution(74901729);
        assertEquals(4, binaryGap);

        binaryGap = solution.solution(1376796946);
        assertEquals(5, binaryGap);
    }
}
