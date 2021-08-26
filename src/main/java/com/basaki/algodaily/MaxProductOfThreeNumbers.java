package com.basaki.algodaily;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, can you write a method
 * maxProductOfThree(unsorted: array) to find the largest product from
 * three of the numbers? For example, given the following array:
 *
 * [-1, 9, 22, 3, -15, -7]
 *
 * The largest product of three numbers is 2310. This results from -15 * -7 * 22.
 */
public class MaxProductOfThreeNumbers {

    public static int maxProductOfThree(int[] unsorted) {
        System.out.println("unsorted: " + Arrays.toString(unsorted));
        Arrays.sort(unsorted);
        System.out.println("sorted:   " + Arrays.toString(unsorted));
        assert unsorted.length >= 3;

        // The largest 3 elements product will be one of these 4 values,
        // assuming it's an ordered list:
        // 1. first 3 elements (highest values)
        // 2. last 3 elements (lowest values – can have 2 large negative
        // values that create a positive and then multipled by a positive)
        // 3. first element and last 2 elements
        // 4. first 2 elements and last element

        int start = 0;
        int end = unsorted.length - 1;

        int prodOf3Largest = unsorted[end] * unsorted[end - 1] * unsorted[end - 2];
        System.out.println("prodOf3Largest: " + prodOf3Largest);
        int prodOf3Smallest = unsorted[start] * unsorted[start + 1] * unsorted[start + 2];
        System.out.println("prodOf3Smallest: " + prodOf3Smallest);
        int prodOfLargestAnd2Smallest = unsorted[end] * unsorted[start] * unsorted[start + 1];
        System.out.println("prodOfLargestAnd2Smallest: " + prodOfLargestAnd2Smallest);

        int max = Math.max(prodOf3Largest, prodOf3Smallest);
        return Math.max(max, prodOfLargestAnd2Smallest);
    }

    public static void main(String... args) {
        int[] unsorted = {-1, 9, 22, 3, -15, -7};
        //sorted: [-15, -7, -1, 3, 9, 22]
        System.out.println(-15 * -7 * 22);
        System.out.println(maxProductOfThree(unsorted));
    }
}
