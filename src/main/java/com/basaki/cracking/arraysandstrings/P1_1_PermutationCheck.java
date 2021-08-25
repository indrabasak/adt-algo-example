package com.basaki.cracking.arraysandstrings;

import java.util.Arrays;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a
 * permutation of the another
 */
public class P1_1_PermutationCheck {

    // Assumpation that its case sensitive
    public boolean permuation(String s, String t) {
        // two string lenghts has to be equal to be permutation of each other
        if (s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }

    private String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);

        return new String(content);
    }

    public static void main(String... args) {
        P1_1_PermutationCheck ex = new P1_1_PermutationCheck();
        System.out.println(ex.permuation("abc", "cba"));
        System.out.println(ex.permuation("abc", "Cba"));
    }
}
