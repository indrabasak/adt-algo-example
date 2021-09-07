package com.basaki.algodaily;

/**
 * Find First Non-Repeating Character
 * You're given a string of random alphanumerical characters with a length
 * between 0 and 1000.
 *
 * Write a method to return the first character in the string that does
 * not repeat itself later on.
 *
 * firstNonRepeat('asdfsdafdasfjdfsafnnunl') should return 'j'
 *
 * Constraints
 * The given string can be empty
 * The string will only contain lowercase/uppercase alphabets and numerals
 * Expected time complexity : O(n)
 * Expected space complexity : O(A) where A is the number of ASCII characters
 */
public class FirstNonRepeat {

    public static char firstNonRepeat(String str) {
        char[] arr = str.toCharArray();

        int[] charSet = new int[128];
        for (int i = 0; i < arr.length; i++) {
            charSet[arr[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (charSet[arr[i]] == 1) {
                return arr[i];
            }
        }

        return '\0';
    }
}
