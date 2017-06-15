package com.basaki;

import java.util.ArrayList;

public class StringToIntegerConversion {

    public static int convertStringToInt(String str) {
        // Integer.parseInt(s);
        // Integer.toString(i)
        boolean neg = false;
        int startIdx = 0;
        int num = 0;

        if (str == null || str.length() == 0) {
            return -1;
        }

        String tempStr = str.trim();
        if (tempStr.length() == 0) {
            return -1;
        }

        if (tempStr.charAt(0) == '-') {
            neg = true;
            startIdx = 1;
        }

        if (neg && tempStr.length() == 1) {
            return -1;
        }

        char[] chars = tempStr.toCharArray();
        for (int i = startIdx; i < chars.length; i++) {
            num *= 10;
            num += chars[i] - '0';
        }

        if (neg) {
            num *= -1;
        }

        return num;
    }

    public static String convertIntToString(int num) {
        boolean neg = false;

        if (num < 0) {
            neg = true;
            num *= -1;
        }

        ArrayList<Character> chars = new ArrayList<Character>();
        do {
            char c = (char) (num % 10 + '0');
            chars.add(c);
            num /= 10;
            System.out.println("***1 " + c);

        } while (num != 0);

        StringBuilder bldr = new StringBuilder();
        if (neg) {
            bldr.append("-");
        }


        for (int i = chars.size() - 1; i >= 0; i--) {
            bldr.append(chars.get(i));
        }

        return bldr.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertStringToInt("-456"));
        System.out.println(convertStringToInt("-"));
        System.out.println(convertStringToInt(""));
        System.out.println(convertStringToInt("   "));

        System.out.println(convertIntToString(-456));
    }

}
