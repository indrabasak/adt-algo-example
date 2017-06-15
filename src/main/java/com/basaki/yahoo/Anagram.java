package com.basaki.yahoo;

public class Anagram {

    public static String findAnagram(String haystack, String needle) {
        String returnVal = "NONE";

        if (haystack == null || needle == null
                || needle.length() > haystack.length()) {
            return returnVal;
        }

        haystack = haystack.toLowerCase();
        needle = needle.toLowerCase();

        int[] needleArray = new int[256];

        boolean[] hay = new boolean[haystack.length()];
        for (int i = 0; i < needle.length(); i++) {
            needleArray[needle.charAt(i) - 'a']++;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (needleArray[haystack.charAt(i) - 'a'] != 0) {
                hay[i] = true;
            }
        }

        int count = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < hay.length; i++) {
            if (hay[i]) {
                count++;
                if (start == -1) {
                    start = i;
                    end = i;
                } else {
                    end = i + 1;
                }
            } else {
                if (count < needle.length()) {
                    count = 0;
                    start = -1;
                    end = -1;
                }
            }
        }

        if (count >= needle.length()) {
            returnVal = haystack.substring(start, end);
        }

        return returnVal;
    }

    public static void main(String[] args) {
        System.out.println(findAnagram("slate", "tea"));
        System.out.println(findAnagram("slate", "let"));
    }

}
