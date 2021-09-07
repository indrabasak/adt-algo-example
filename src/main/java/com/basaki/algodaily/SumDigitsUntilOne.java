package com.basaki.algodaily;

/**
 * We're provided a positive integer num. Can you write a method to repeatedly
 * add all of its digits until the result has only one digit?
 *
 * Here's an example: if the input was 49, we'd go through the following steps:
 *
 * SNIPPET
 * // start with 49
 * 4 + 9 = 13
 *
 * // move onto 13
 * 1 + 3 = 4
 * We would then return 4.
 *
 * Constraints
 * Input will be in the range between 0 and 1000000000
 * Expected time complexity : O(log n)
 * Expected space complexity : O(1)
 */
public class SumDigitsUntilOne {

    public static int sumDigits(int input) {
        if (input / 10 == 0) {
            return input;
        }

        int num = input;
        int sum = 0;

        while ((num / 10) > 0) {
            sum += num % 10;
            num /= 10;
        }

        sum += num % 10;

        return sumDigits(sum);
    }

}
