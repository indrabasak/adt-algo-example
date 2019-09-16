package com.basaki;

import java.util.ArrayList;

@SuppressWarnings({"squid:S3516"})
public class MaximumSuffixOfAString {

    public String findMaxSuffix(String input) {
        if (input == null) {
            return null;
        }

        char[] chars = input.toCharArray();
        boolean[] maxChar = new boolean[chars.length];

        char c = chars[0];
        ArrayList<Integer> lowIdxs = new ArrayList<>();
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
