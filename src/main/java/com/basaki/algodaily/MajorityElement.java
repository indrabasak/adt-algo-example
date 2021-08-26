package com.basaki.algodaily;

import java.util.HashMap;
import java.util.Map;

/**
 * Suppose we're given an array of numbers like the following:
 *
 * [4, 2, 4]
 *
 * Could you find the majority element? A majority is defined as "the greater
 * part, or more than half, of the total. It is a subset of a set consisting
 * of more than half of the set's elements."
 *
 * Let's assume that the array length is always at least one, and that
 * there's always a majority element.
 *
 * In the example above, the majority element would be 4.
 */
public class MajorityElement {

    private static class Counter {
        private int count;

        public Counter(int count) {
            this.count = count;
        }
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Counter> map = new HashMap<>();
        int maxCount = 0;
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Counter(1));
                if (1 > maxCount) {
                    maxCount = 1;
                    num = nums[i];
                }
            } else {
                Counter counter = map.get(nums[i]);
                counter.count++;
                if (counter.count > maxCount) {
                    maxCount = counter.count;
                    num = nums[i];
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 1, 1, 1, 4, 2, 4, 4, 3, 1, 1, 1 })); // 1
    }
}
