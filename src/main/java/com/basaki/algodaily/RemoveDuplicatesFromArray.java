package com.basaki.algodaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Remove Duplicates From Array
 *
 * Given an array, return another array with just the ordered unique elements
 * from the given array. In other words, you're removing any duplicates.
 *
 * Note: Order needs to be preserved, so no sorting should be done. And the
 * order should be maintained with the first occurrence of the element in
 * the given array.
 *
 * Constraints
 * Length of the array <= 100000
 * The values in the array between -1000000000 and 1000000000
 * Expected time complexity: O(n)
 * Expected space complexity: O(n)
 */
public class RemoveDuplicatesFromArray {

    public static List<Integer> uniques(int[] array) {
        Set<Integer> set = new HashSet<>();
        List<Integer> unique = new ArrayList<>();

        for (int i : array) {
            if (!set.contains(i)) {
                unique.add(i);
                set.add(i);
            }
        }

        return unique;
    }
}
