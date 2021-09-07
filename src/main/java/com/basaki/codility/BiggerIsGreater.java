package com.basaki.codility;

/**
 * Lexicographical order is often known as alphabetical order when dealing
 * with strings. A string is greater than another string if it comes later in
 * a lexicographically sorted list.
 * <p>
 * Given a word, create a new word by swapping some or all of its characters.
 * This new word must meet two criteria:
 * <p>
 * It must be greater than the original word
 * It must be the smallest word that meets the first condition
 * <p>
 * Example
 * <p>
 * w = abcd
 * <p>
 * The next largest word is abdc.
 * <p>
 * Complete the function biggerIsGreater below to create and return the new string
 * meeting the criteria. If it is not possible, return no answer.
 * <p>
 * Function Description
 * <p>
 * Complete the biggerIsGreater function in the editor below.
 * <p>
 * biggerIsGreater has the following parameter(s):
 * <p>
 * string w: a word
 * Returns
 * - string: the smallest lexicographically higher string possible or no answer
 */
public class BiggerIsGreater {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */
    public static String biggerIsGreater(String w) {
        // Algorithm - https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
        // word           =      A  B  C  F  D  D  A

        // 1. Find the largest index k such that a[k] < a[k + 1].
        // If no such index exists, the permutation is the last permutation.
        // identify pivot =      A  B  C  F  D  D  A
        //                            ---

        // 2. Find the largest index l greater than k such that a[k] < a[l].
        // right most successor
        // to replace pivot =    A  B  C  F  D  D  A
        //                                     ---

        // 3. Swap the value of a[k] with that of a[l].
        // swap the pivot with the
        // rightmost successor = A  B  D  F  D  C  A
        //                            ---      ---

        // 4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
        // Reverse suffix =     A  B  D  A  D  C  F
        //                              ---      ---

        if (w == null || w.isEmpty()) {
            return "no answer";
        }

        char[] arr = w.toCharArray();

        // find non-increasing suffix
        int k = arr.length - 1;
        boolean found = false;
        while ((k > 0) && arr[k - 1] >= arr[k]) {
            k--;
        }

        if (k <= 0) {
            return "no answer";
        }

        // find the rightmost successor to pivot in the suffix
        int l = arr.length - 1;
        while (arr[l] <= arr[k - 1]) {
            l--;
        }

        // swap the pivot with the rightmost character
        char tmp = arr[k - 1];
        arr[k - 1] = arr[l];
        arr[l] = tmp;

        // reverse the suffix
        if (l + 1 <= arr.length - 1) {
            tmp = arr[k];
            arr[k] = arr[l + 1];
            arr[l + 1] = tmp;
        } else {
            tmp = arr[k];
            arr[k] = arr[l];
            arr[l] = tmp;
        }

        return new String(arr);
    }
}
