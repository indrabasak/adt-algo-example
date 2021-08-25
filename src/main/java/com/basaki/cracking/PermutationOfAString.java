package com.basaki.cracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to print all permutations of a string. For simplicity,
 * assume all characters are unique.
 */
public class PermutationOfAString {

    public static List<String> findPermutation(String str) {
        List<String> permutations = new ArrayList<>();
        List<String> permsAtPrevLevel = new ArrayList<>();

        char[] strChars = str.toCharArray();
        permutations.add(Character.toString(strChars[0]));
        permsAtPrevLevel.add(Character.toString(strChars[0]));
        for (int i = 1; i < strChars.length; i++) {
            print(permsAtPrevLevel);
            List<String> permsAtCurrLevel = new ArrayList<>();
            for (int j = 0; j < permsAtPrevLevel.size(); j++) {
                String perm = permsAtPrevLevel.get(j);
                permsAtCurrLevel.addAll(insertCharInEveryPossiblePlace(perm, strChars[i]));
            }
            permsAtPrevLevel.clear();
            permsAtPrevLevel.addAll(permsAtCurrLevel);
            permutations.addAll(permsAtCurrLevel);
            permsAtCurrLevel.clear();
        }

        print(permsAtPrevLevel);

        return permutations;
    }

    private static List<String> insertCharInEveryPossiblePlace(String s, char c) {
        List<String> permutations = new ArrayList<>();
        String cStr = Character.toString(c);
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(0, i) + cStr + s.substring((i));
        }

        permutations.add(s + cStr);

        return permutations;
    }

    private static void print(List<String> permutations) {
        for (String perm : permutations) {
            System.out.print(perm + " ");
        }

        System.out.println();
    }

    public static void main(String... args) {
        List<String> permutations = findPermutation("abcd");
        System.out.println("*** size: " + permutations.size());
    }
}
