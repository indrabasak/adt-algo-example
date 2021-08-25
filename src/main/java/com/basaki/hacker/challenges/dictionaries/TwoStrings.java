package com.basaki.hacker.challenges.dictionaries;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 *
 * Example
 *
 *
 * These share the common substring .
 *
 *
 *
 * These do not share a substring.
 *
 * Function Description
 *
 * Complete the function twoStrings in the editor below.
 *
 * twoStrings has the following parameter(s):
 *
 * string s1: a string
 * string s2: another string
 * Returns
 *
 * string: either YES or NO
 * Input Format
 *
 * The first line contains a single integer , the number of test cases.
 *
 * The following  pairs of lines are as follows:
 *
 * The first line contains string .
 * The second line contains string .
 * Constraints
 *
 *  and  consist of characters in the range ascii[a-z].
 * Output Format
 *
 * For each pair of strings, return YES or NO.
 *
 * Sample Input
 *
 * 2
 * hello
 * world
 * hi
 * world
 * Sample Output
 *
 * YES
 * NO
 * Explanation
 *
 * We have  pairs to check:
 *
 * , . The substrings  and  are common to both strings.
 * , .  and  share no common substrings.
 */
public class TwoStrings {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public static String twoStringsOne(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        for (int i = 0; i < s1Chars.length; i++) {
            char current = s1Chars[i];
            if (s2.indexOf(current) != -1) {
                return "YES";
            }
        }


        return "NO";
    }

    public static String twoStrings(String s1, String s2) {
        Set<Character> s1Set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            s1Set.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (s1Set.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String... args) {
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }
}
