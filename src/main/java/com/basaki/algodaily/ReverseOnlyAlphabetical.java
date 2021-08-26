package com.basaki.algodaily;

/**
 * You are given a string that contains alphabetical characters (a - z, A - Z)
 * and some other characters ($, !, etc.). For example, one input may be:
 *
 * 'sea!$hells3'
 *
 * Can you reverse only the alphabetical ones?
 *
 * reverseOnlyAlphabetical('sea!$hells3');
 * // 'sll!$ehaes3'
 * Constraints
 * Length of the given string <= 100000
 * The string comprises of ASCII characters
 * Expected time complexity : O(n)
 * Expected space complexity : O(n)
 */
public class ReverseOnlyAlphabetical {

    public static String reverseOnlyAlphabetical(String str) {
        if (str == null) {
            return str;
        }

        int start = 0;
        int end = str.length() - 1;
        char[] array = str.toCharArray();

        char[] reversed = new char[str.length()];

        while (start <= end) {
            if (isAlphaNumeric(array[start]) && isAlphaNumeric(array[end])) {
                char tmp = array[start];
                reversed[start] = array[end];
                reversed[end] = tmp;
                start++;
                end--;
            } else if (!isAlphaNumeric(array[start])) {
                reversed[start] = array[start];
                start++;
            } else {
                reversed[end] = array[end];
                end--;
            }
        }

        return new String(reversed);
    }

    private static boolean isAlphaNumeric(char c) {
        int cNum = Character.getNumericValue(c);
        int aNum = Character.getNumericValue('a');
        int zNum = Character.getNumericValue('z');

        return cNum >= aNum && cNum <= zNum;
    }

    public static void main(String... args) {
        // "sea!$hells3"
        // 'sll!$ehaes3'
        System.out.println("sea!$hells3");
        System.out.println(reverseOnlyAlphabetical("sea!$hells3"));
    }
}
