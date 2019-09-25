package com.basaki.codility.lesson.two;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class CyclicRotationTest {

    @Test
    public void testSolution() {
        CyclicRotation soln = new CyclicRotation();

        int[] a = {3, 8, 9, 7, 6};

        int[] b = {6, 3, 8, 9, 7};
        assertTrue(Arrays.equals(b, soln.solution(a, 1)));

        int[] c = {3, 8, 9, 7, 6};
        int[] d = {9, 7, 6, 3, 8};
        assertTrue(Arrays.equals(d, soln.solution(c, 3)));

        int[] e = {0, 0, 0};
        int[] f = {0, 0, 0};
        assertTrue(Arrays.equals(f, soln.solution(e, 1)));

        int[] g = {1, 2, 3, 4};
        int[] h = {1, 2, 3, 4};
        assertTrue(Arrays.equals(h, soln.solution(g, 4)));

        int[] i = {1};
        int[] j = {1};
        assertTrue(Arrays.equals(j, soln.solution(i, 4)));

        int[] l = {1, 2, 3, 4};
        int[] m = {1, 2, 3, 4};
        assertTrue(Arrays.equals(m, soln.solution(l, -4)));
    }
}
