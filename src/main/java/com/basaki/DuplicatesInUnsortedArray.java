package com.basaki;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicatesInUnsortedArray {

    public static void findDuplicates(int[] input) {
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        for (int i = 0; i < input.length; i++) {
            Integer value = map.get(input[i]);
            if (value == null) {
                map.put(input[i], 1);
            } else {
                map.put(input[i], value + 1);
            }
        }

        Map<Integer, Integer> output = new LinkedHashMap<Integer, Integer>();
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " --> " + entry.getValue());
                output.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {7, 5, 7, 2, 3, 5, 29, 30, 29, 7, 2, 2, 2, 2};
        findDuplicates(input);
    }
}
