package com.basaki.cracking.arraysandstrings;

public class P1_4_PalindromePermutation {

    public boolean isPermutationOfPalindrome(String phrase) {
        // 1. A palindrome is a string that is same forwards and backwards,
        // example,
        // 2. Strings that are even length (after removing all non-letter characters),
        // must have even counts of characters.
        // 3. Strings that are odd length, must have even counts of characters
        // one letter that is odd

        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int index = getCharNumber(c);
            if (index != -1) {
                table[index]++;
            }
        }

        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }

    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (val <= z && val >= a) {
            return val - a;
        }

        return -1;
    }

    public static void main(String... args) {
        P1_4_PalindromePermutation ex = new P1_4_PalindromePermutation();
        String phrase = "Tact Coa";
        System.out.println(phrase);
        System.out.println(ex.isPermutationOfPalindrome(phrase));

        phrase = "Tact Co";
        System.out.println(phrase);
        System.out.println(ex.isPermutationOfPalindrome(phrase));
    }
}
