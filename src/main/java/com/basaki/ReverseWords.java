package com.basaki;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String str1 = "I want to play";
        //System.out.println("reverse of " + str1 + " is -> " + rw.reverse(str1));
        String str2 = "I     want     to     play";
        //System.out.println("reverse of " + str2 + " is -> " + rw.reverse(str2));

        System.out.println("* reverse of " + str1 + " is -> " + rw.reverse2(str1));
        System.out.println("* reverse of " + str2 + " is -> " + rw.reverse2(str2));

    }

    public String reverse(String str) {
        if (str == null) {
            return str;
        }

        String[] words = str.split(" ");
        Stack<String> stk = new Stack<String>();

        for (String word : words) {
            stk.push(word);
        }

        String revStr = "";
        while (!stk.empty()) {
            revStr = revStr + " " + stk.pop();
        }

        return revStr.trim();
    }

    public String reverse2(String str) {
        if (str == null) {
            return str;
        }

        char[] letters = str.toCharArray();
//        for (int i = 0; i < letters.length; i++)
//        {
//            System.out.print(letters[i]);
//        }
        System.out.println();
        for (int i = 0; i < letters.length / 2; i++) {
            swap(letters, i, letters.length - 1 - i);
        }
//        for (int i = 0; i < letters.length; i++)
//        {
//            System.out.print(letters[i]);
//        }

        ArrayList<Character> list = new ArrayList<Character>();
        String revStr = "";
        for (int i = 0; i < letters.length; i++) {
            if (!Character.isWhitespace(letters[i])) {
                System.out.println("---1 " + letters[i]);
                list.add(letters[i]);
            } else {
                System.out.println("---2");
                String tmp = "";
                for (Character c : list) {
                    tmp = c + tmp;
                }
                //System.out.println("--- 2 tmp: " + tmp);
                revStr += " " + tmp;
                //System.out.println("--- 2 revStr: " + revStr);
                list.clear();
            }
        }

        String tmp = "";
        for (Character c : list) {
            tmp = c + tmp;
        }
        revStr += " " + tmp;

        return revStr;
    }

    private void swap(char[] letters, int i, int j) {
        if (i >= 0 && i < letters.length && j >= 0 && j < letters.length) {
            char tmp = letters[i];
            letters[i] = letters[j];
            letters[j] = tmp;
        }
    }

}
