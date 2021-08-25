package com.basaki.hacker.challenges.arrays;

/**
 * There is a string, , of lowercase English letters that is repeated infinitely many times. Given an integer, , find and print the number of letter a's in the first  letters of the infinite string.
 *
 * Example
 *
 *
 * The substring we consider is , the first  characters of the infinite string. There are  occurrences of a in the substring.
 *
 * Function Description
 *
 * Complete the repeatedString function in the editor below.
 *
 * repeatedString has the following parameter(s):
 *
 * s: a string to repeat
 * n: the number of characters to consider
 * Returns
 *
 * int: the frequency of a in the substring
 * Input Format
 *
 * The first line contains a single string, .
 * The second line contains an integer, .
 *
 * Constraints
 *
 * For  of the test cases, .
 * Sample Input
 *
 * Sample Input 0
 *
 * aba
 * 10
 * Sample Output 0
 *
 * 7
 * Explanation 0
 * The first  letters of the infinite string are abaabaabaa. Because there are  a's, we return .
 *
 * Sample Input 1
 *
 * a
 * 1000000000000
 * Sample Output 1
 *
 * 1000000000000
 * Explanation 1
 * Because all of the first  letters of the infinite string are a, we return .
 */
public class RepeatedString {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        long count = 0;
        if (s == null) {
            return count;
        }

        long countofAInSubString = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                countofAInSubString++;
            }
        }

        long repeat =  n/s.length();
        count = countofAInSubString * repeat;
        long extraCharLen = n - s.length() * repeat;

        for (char c : s.substring(0, (int) extraCharLen).toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }

        return count;
    }

    public static void main(String... arg) {
        System.out.println(repeatedString("aba", 10));
    }
}
