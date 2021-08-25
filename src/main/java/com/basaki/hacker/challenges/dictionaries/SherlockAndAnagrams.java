package com.basaki.hacker.challenges.dictionaries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SherlockAndAnagrams {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int sherlockAndAnagramsTwo(String s) {
        int anagrams = 0;
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                System.out.print(str + ", ");

                if (dict.containsKey(str)) {
                    int count = dict.get(str);
                    anagrams = anagrams + count;
                    for (int k = 0; k < count; k++) {
                        System.out.println("\n[" + str + ", " + str + "]");
                    }

                }

                if (str.length() > 1) {
                    String reverse = reverse(str);
                    if (!str.equals(reverse)) {
                        //System.out.println("rev: " + reverse);
                        if (dict.containsKey(reverse)) {
                            //System.out.println("#");
                            int count = 0;
                            count = dict.get(reverse);
                            anagrams = anagrams + count;
                            System.out.println("\n[" + str + ", " + reverse + "]");
                        }
                    }
                }

                if (str.length() != s.length()) {
                    int count = 1;
                    if (dict.containsKey(str)) {
                        count = dict.get(str);
                        count++;
                    }
                    dict.put(str, count);
                }
            }
        }

        System.out.println();

        return anagrams;
    }

    public static int sherlockAndAnagrams(String s) {
        int anagrams = 0;
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                int count = 1;
                //exact match
                if (dict.containsKey(str)) {
                    count = dict.get(str);
                    anagrams = anagrams + count;
                    count++;
                } else {

                }
                dict.put(str, count);
                System.out.print(str + ", ");
            }
        }

        //kkk
        //kk, kk
        //kk

        //kkkk
        //kk, kk, kk
        //kk, kk
        //kk

        System.out.println();
        for (Map.Entry<String, Integer> entries : dict.entrySet()) {

        }

        return anagrams;
    }

    private static String[] getAnagrams(String s) {
        Set<String> anagrams = new HashSet<>();

        return null;
    }

    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            int j = chars.length - 1 - i;
            char jChar = chars[j];
            chars[j] = chars[i];
            chars[i] = jChar;
        }

        return new String(chars);
    }

    public static void main (String... args) {
        //System.out.println(sherlockAndAnagrams("abba"));
        //System.out.println(sherlockAndAnagrams("cdcd"));
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        //System.out.println(sherlockAndAnagrams("kkkk"));
        // [k, k],
        // [k, k] [k, k],
        // [k, k], [k, k], [k, k]
        // [kk, kk]
    }

}
