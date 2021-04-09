package com.basaki.levenshtein;

import java.util.Arrays;

public class LevenshteinTwo {

    static int calculate(String x, String y) {
        if (x.isEmpty()) {
            return y.length();
        }

        if (y.isEmpty()) {
            return x.length();
        }

//        int substitution = calculate(x.substring(1), y.substring(1))
//                + costOfSubstitution(x.charAt(0), y.charAt(0));
//        int insertion = calculate(x, y.substring(1)) + 1;
//        int deletion = calculate(x.substring(1), y) + 1;
//
//        return min(substitution, insertion, deletion);
        String altX = x;
        if (x.length() > y.length()) {
            altX = x.substring(0, y.length());
        }

        String altY = y;
        if (y.length() > x.length()) {
            altY = y.substring(0, x.length());
        }

        for (int i = 0; i < altX.length(); i++) {

        }


        return 0;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
}
