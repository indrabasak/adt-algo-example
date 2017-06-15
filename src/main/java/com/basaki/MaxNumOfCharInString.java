package com.basaki;

public class MaxNumOfCharInString {

    public static void maxChar(String input) {
        if (input == null) {
            System.out.println("Null string");
        }

        int num[] = new int[256];
        char[] chars = input.toCharArray();
        int maxValue = Integer.MIN_VALUE;
        //System.out.println(maxValue);
        int maxIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            num[chars[i]] = num[chars[i]] + 1;
            if (num[chars[i]] > maxValue) {
                maxIndex = chars[i];
                maxValue = num[maxIndex];

            } else if (num[chars[i]] == maxValue) {
                if (chars[i] < maxIndex) {
                    maxIndex = i;
                }
            }
        }

        System.out.println(maxIndex);
        System.out.println(
                "max char: " + (char) maxIndex + " occurrence: " + maxValue);
    }

    public static void main(String[] args) {
        maxChar("hfvhhhhtytyfdfdddddddddddeeeeeeeeeeeeggggggggggggg");
        maxChar("abbacc");

    }

}
