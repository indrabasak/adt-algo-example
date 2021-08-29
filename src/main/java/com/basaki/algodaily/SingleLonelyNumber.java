package com.basaki.algodaily;

import java.util.HashMap;
import java.util.Map;

/**
 * In a given array of numbers, one element will show up once and the
 * others will each show up twice. Can you find the number that only
 * appears once in O(n) linear time? Bonus points if you can do it
 * in O(1) space as well.
 */
public class SingleLonelyNumber {
    private static class Counter {
        private int count = 1;
    }

    public static int lonelyNumber(int[] numbers) {
        Map<Integer, Counter> map = new HashMap<>();

        for (int n : numbers) {
            if (!map.containsKey(n)) {
                map.put(n, new Counter());
            } else {
                map.get(n).count++;
            }
        }

        int num = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Counter> e : map.entrySet()) {
            if (e.getValue().count == 1) {
                num = e.getKey();
            }
        }


        return num;
    }
}
