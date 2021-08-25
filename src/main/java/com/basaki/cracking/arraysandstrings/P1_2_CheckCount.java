package com.basaki.cracking.arraysandstrings;

/**
 * Check if two strings have identical characters count.
 */
public class P1_2_CheckCount {

    // assumptions that all characters are extended ASCII
    public boolean checkCount(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        for (char c : t.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return false;
    }
}
