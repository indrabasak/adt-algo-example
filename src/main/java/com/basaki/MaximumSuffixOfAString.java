package com.basaki;

import java.util.ArrayList;

public class MaximumSuffixOfAString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String findMaxSuffix(String input) {
        if (input == null) {
            return null;
        }

        char[] chars = input.toCharArray();
        boolean[] maxChar = new boolean[chars.length];

        char c = chars[0];
        ArrayList<Integer> lowIdxs = new ArrayList<Integer>();
        lowIdxs.add(0);
        maxChar[0] = true;
        for (int i = 1; i < chars.length; i++) {
            int diff = c - chars[i];
            if (diff == 0) {
                maxChar[i] = true;
                lowIdxs.add(i);
            } else if (diff < 1) {
                maxChar[i] = false;
            } else {
                maxChar[i] = true;
                for (int x : lowIdxs) {
                    maxChar[x] = false;
                }
                lowIdxs.clear();
                lowIdxs.add(i);
            }
        }

        return null;
    }

}
