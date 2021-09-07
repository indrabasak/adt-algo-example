package com.basaki.cracking.moderate;

/**
 * Number Swapper: Write a function to swap two number in place (that is,
 * without temporary variables.
 */
public class NumberSwapper {

    public static void swap(int[] nums) {
        if (nums.length != 2) {
            return;
        }

        // save the diff
        nums[1] = nums[1] - nums[0];
        // add the diff to position 0
        nums[0] = nums[0] + nums[1];

        // subtrcat the diff from position 0
        nums[1] = nums[0] - nums[1];
    }
}
