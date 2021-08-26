package com.basaki.algodaily;

/**
 * Given a string str, can you write a method that will return True if is a
 * palindrome and False if it is not? If you'll recall, a palindrome is defined
 * as "a word, phrase, or sequence that reads the same backward as forward".
 * For now, assume that we will not have input strings that contain special
 * characters or spaces, so the following examples hold:
 *
 * let str = 'thisisnotapalindrome';
 * isPalindrome(str);
 * // false
 *
 * str = 'racecar';
 * isPalindrome(str);
 * // true
 * For an extra challenge, try to ignore non-alphanumerical characters.
 * The final solution that we present will handle all edge cases.
 *
 * Constraints
 * Length of the given string <= 100000
 * The string will consist of ASCII characters (some or all)
 * Expected time complexity : O(n)
 * Expected space complexity : O(1)
 */
public class ValidatePalindrome {

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        // case insensitive
        char[] array = str.toLowerCase().toCharArray();

        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            //System.out.println(i + ": " + array[i] + " - " + j + ": " + array[j]);
            // ignoring invalid character
            if (isAlphaNumeric(array[i]) && isAlphaNumeric(array[j]))  {
                //System.out.println("-- 1");
                if (array[i] != array[j]) {
                    return false;
                }
                i++;
                j--;
            } else if (!isAlphaNumeric(array[i])) {
                i++;
            } else {
                j--;
            }
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        int cNum = Character.getNumericValue(c);
        int aNum = Character.getNumericValue('a');
        int zNum = Character.getNumericValue('z');

        return cNum >= aNum && cNum <= zNum;
    }

    public static void main(String... args) {
        System.out.println(isPalindrome("thisisnotapalindrome"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("A Santa Lived As a Devil At NASA"));
    }
}
