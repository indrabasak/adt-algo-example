package com.basaki.algodaily;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Missing Number in Array:
 * We're given an array of continuous numbers that should increment
 * sequentially by 1, which just means that we expect a sequence like:
 *
 * [1, 2, 3, 4, 5, 6, 7]
 *
 * However, we notice that there are some missing numbers in the sequence.
 *
 * [1, 2, 4, 5, 7]
 *
 * Can you write a method missingNumbers that takes an array of continuous
 * numbers and returns the missing integers?
 *
 * missingNumbers([1, 2, 4, 5, 7]);
 * // [3, 6]
 * Constraints
 * Length of the array <= 100000
 * The array will always contain non negative integers (including 0)
 * Expected time complexity : O(n)
 * Expected space complexity : O(1)
 */
public class MissingNumbersInArray {

    public static List<Integer> missingNumbers(int[] numArr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int j : numArr) {
            if (j < min) {
                min = j;
            } else if (j > max) {
                max = j;
            }
        }

        boolean[] numSet = new boolean[max - min + 1];
        for (int j : numArr) {
            numSet[j - min] = true;
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < numSet.length; i++) {
            if (!numSet[i]) {
                missing.add(i + min);
            }
        }

        return missing;
    }
}
