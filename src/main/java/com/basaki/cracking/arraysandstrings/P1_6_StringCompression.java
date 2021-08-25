package com.basaki.cracking.arraysandstrings;

public class P1_6_StringCompression {

    public String compress(String str) {
        StringBuilder bldr = new StringBuilder();

        char prevChar = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar == prevChar) {
                count++;
            } else {
                bldr.append(prevChar).append(count);
                prevChar = currChar;
                count = 1;
            }
        }
        bldr.append(prevChar).append(count);

        String compressedStr = bldr.toString();
        if (str.length() > compressedStr.length()) {
            return compressedStr;
        }

        return str;
    }

    public static void main(String... args) {
        P1_6_StringCompression ex = new P1_6_StringCompression();
        String str = "aabcccccaaa";
        String compressed = ex.compress(str);
        System.out.println(str);
        System.out.println(compressed);

        str = "aab";
        compressed = ex.compress(str);
        System.out.println(str);
        System.out.println(compressed);
    }
}
