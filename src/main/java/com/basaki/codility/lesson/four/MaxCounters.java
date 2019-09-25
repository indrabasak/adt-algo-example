package com.basaki.codility.lesson.four;

import java.util.Arrays;

/**
 * You are given N counters, initially set to 0, and you have two possible
 * operations on them:
 *
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents
 * consecutive operations:
 *
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int N, int[] A); }
 *
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
@SuppressWarnings({"squid:S00117"})
class MaxCounters {

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8

        int[] counters = new int[N];
        Arrays.fill(counters, 0);

        int currentMax = 0;
        int currentBase = 0;
        for (int i = 0; i < A.length; i++) {
            int counter = A[i] - 1;

            if (counter >= 0 && counter < counters.length) {
                if (counters[counter] < currentBase) {
                    counters[counter] = currentBase + 1;
                } else {
                    counters[counter] = counters[counter] + 1;
                }

                if (counters[counter] > currentMax) {
                    currentMax = counters[counter];
                }
            } else if (counter >= counters.length) {
                currentBase = currentMax;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < currentBase) {
                counters[i] = currentBase;
            }
        }

        return counters;
    }

    public int[] solutionOne(int N, int[] A) {
        // write your code in Java SE 8

        int[] counters = new int[N];
        Arrays.fill(counters, 0);

        int currentMax = 0;
        for (int i = 0; i < A.length; i++) {
            int counter = A[i] - 1;

            if (counter >= 0 && counter < counters.length) {
                counters[counter] = counters[counter] + 1;
                if (counters[counter] > currentMax) {
                    currentMax = counters[counter];
                }
            } else if (counter >= counters.length) {
                Arrays.fill(counters, currentMax);
            }
        }

        return counters;
    }
}
