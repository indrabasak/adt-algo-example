package com.basaki.algodaily;

/**
 * Given an integer num, write a method to determine if it is a power of 3.
 *
 * Constraints
 * The given would be a non zero positive integer in the range between 1 and 2147483647
 * Expected space complexity : O(logn)
 * Expected time complexity : O(1)
 */
public class PowerOfThree {

    public static boolean powerOfThree(int num) {
        if (num < 1) {
            return false;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        return num == 1;
    }

    public static void main(String... args) {
        System.out.println(powerOfThree(8));
        System.out.println(powerOfThree(9));

        System.out.println(powerOfThree(7));
    }
}
