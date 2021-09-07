package com.basaki.algodaily;

/**
 * How would you write a function to detect a substring in a string?
 *
 * If the substring can be found in the string, return the index at which
 * it starts. Otherwise, return -1.
 *
 * Important-- do not use the native String class's built-in substring or
 * substr method. This exercise is to understand the underlying implementation
 * of that method.
 *
 * Constraints
 * Length of both the given strings <=100000
 * The strings would never be null
 * The strings will only consist of lowercase letters
 * Expected time complexity : O(n)
 * Expected space complexity : O(1)
 */
public class DetectSubstringInString {

    public static int detectSubstring(String str, String subStr) {
        if (str == null || subStr == null || subStr.length() > str.length()) {
            return -1;
        }

        char[] strChars = str.toCharArray();
        char[] subStrChars = subStr.toCharArray();

        int index = 0;
        boolean found = false;
        while (index < strChars.length && !found) {
            if (strChars[index] == subStrChars[0]) {
                if ((index + subStrChars.length - 1) >  strChars.length) {
                    return -1;
                }

                found = true;
                for (int i = 1; i < subStrChars.length; i++) {
                    if (subStrChars[i] != strChars[index + i]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return index;
                }
            }
            index++;
        }

        return -1;
    }
}
