package com.basaki.codility.lesson.two;

import java.util.HashMap;
import java.util.Map;

/**
 * [100%] OddOccurrencesInArray
 *
 * Find value that occurs in odd number of elements.
 *
 * A non-empty array A consisting of N integers is given. The array contains
 * an odd number of elements, and each element of the array can be paired
 * with another element that has the same value, except for one element
 * that is left unpaired.
 *
 * For example, in array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers fulfilling the above
 * conditions, returns the value of the unpaired element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the function should return 7, as explained in the example above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 */
@SuppressWarnings({"squid:S00117"})
class OddOccurrencesInArray {

    public int solution(int[] A) {
        // write your code in Java SE 8

        if (A == null || (A.length % 2 == 0)) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int key : A) {
            if (!countMap.containsKey(key)) {
                countMap.put(key, 1);
            } else {
                countMap.put(key, countMap.get(key) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
