package com.basaki.cracking.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 10.2 Group Anagrams: Write a method to sort an array of strings so that
 * all the anagrams are next to each other.
 */
public class P10_2_GroupAnagrams {

    public void sort(String[] array) {
        HashMap<String, List<String>> mapList = new HashMap<>();

        for (String s : array) {
            String key = sort(s);
            if (!mapList.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                mapList.put(key, list);
            } else {
                mapList.get(key).add(s);
            }
        }

        // convert table to array
        int i = 0;
        for (List<String> list : mapList.values()) {
            for (String s : list) {
                array[i] = s;
                i++;
            }
        }
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    public static void main(String... args) {
        String[] array = {"hello", "john", "ollhe", "abc", "njho"};
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();

        P10_2_GroupAnagrams ex = new P10_2_GroupAnagrams();
        ex.sort(array);
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
