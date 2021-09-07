package com.basaki.algodaily;

/**
 * Missing Number In Unsorted:
 * Assume we're given an unsorted array of numbers such as this:
 *
 * [ 2, 5, 1, 4, 9, 6, 3, 7 ]
 *
 * We are told that when this array is sorted, there is a series of n
 * consecutive numbers. You are given a lower bound and an upper bound for
 * this sequence.
 *
 * There is one consecutive number missing, and we need to find it.
 *
 * As an example, look at the below example. We're told that the lower bound
 * is 1 and the upper bound is 9. The number that's missing in the unsorted
 * series bounded by these two number is 8.
 */
public class MissingNumberInUnsorted {

    public static int missingInUnsorted(int[] arr, int lowerBound, int upperBound) {
        boolean[] tracker = new boolean[upperBound - lowerBound + 1];
        for (int j : arr) {
            if (j < lowerBound || j > upperBound) {
                return 0;
            }
            tracker[j - lowerBound] = true;
        }

        for (int i = 0; i < tracker.length; i++) {
            if (!tracker[i]) {
                return i + lowerBound;
            }
        }


        return 0;
    }
}
