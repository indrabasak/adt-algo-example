package com.basaki.cracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a smaller string s and a bigger string b, design an algorithm to
 * find all permutations of the shorter string within the longer one. Print
 * the location of each permutation.
 */
public class PermutationOfSInB {

    public static int findPermutation(String b, String s) {
        int total = 0;

        char[] bChars = b.toCharArray();
        for (int i = 0; i < (b.length() - s.length() + 1); i++) {
            if (isPermutation(bChars, i, s.length(), createMap(s))) {
                total++;
            }
        }

        return total;
    }

    private static boolean isPermutation(char[] sub, int startIndex, int length,
                                         Map<Character, Integer> map) {
        int i = 0;
        while (i < length) {
            char c = sub[startIndex + i];
            if (!isExist(map, c)) {
                return false;
            }
            i++;
        }

        int endIndex = startIndex + length;
        System.out.println("[" + startIndex + ", " + endIndex + "]");

        return true;
    }

    private static boolean isExist(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) {
            return false;
        }

        int count = map.get(c);
        count--;
        if (count == 0) {
            map.remove(c);
        } else {
            map.put(c, count);
        }

        return true;
    }

    private static Map<Character, Integer> createMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                count++;
                map.put(c, count);
            }
        }

        return map;
    }

    public static void main(String... args) {
        System.out.println(findPermutation("cbabadcbbabbcbabaabccbabc", "abbc"));
    }
}
