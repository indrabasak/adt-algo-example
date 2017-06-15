package com.basaki;

import java.util.ArrayList;
import java.util.List;

public class SeattleNicePlaceSplit {

    public static void split(String input) {
        char[] buffer = input.toCharArray();
        List<Character> sentence = new ArrayList<Character>();
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == '.' || buffer[i] == ',' || buffer[i] == '!') {
                StringBuilder bldr = new StringBuilder();
                int j = 0;
                for (Character c : sentence) {
                    if (j == 0 && c != ' ') {
                        c = Character.toUpperCase(c);
                        System.out.println("----- " + c);
                        j++;
                    }
                    bldr.append(c);

                }
                bldr.append('.');
                System.out.println(bldr.toString().trim());
                sentence.clear();
            } else {
                sentence.add(buffer[i]);
            }
        }
    }

    public static void split2(String input) {
        String[] sentences = input.split("\\.|\\,|\\!");
        for (String sentence : sentences) {
            String temp = sentence.trim();
            StringBuilder bldr = new StringBuilder();
            bldr.append(Character.toUpperCase(temp.charAt(0)));
            bldr.append(temp.substring(1));
            bldr.append(".");
            System.out.println(bldr.toString());
        }
    }

    public static void main(String[] args) {
        split("Seattle is a nice place. Work Hard! have Fun, make History!");
        split2("Seattle is a nice place. Work Hard! have Fun, make History!");

    }

}
