package com.basaki.algodaily;

/**
 * Fizz Buzz is a classic interview question that apparently many engineering
 * candidates can't solve! Let's cover it today.
 *
 * We're given a number in the form of an integer n.
 *
 * Write a function that returns the string representation of all numbers from 1 to n based on the following rules:
 *
 * If it's a multiple of 3, represent it as "fizz".
 *
 * If it's a multiple of 5, represent it as "buzz".
 *
 * If it's a multiple of both 3 and 5, represent it as "fizzbuzz".
 *
 * If it's neither, just return the number itself.
 */
public class FizzBuzz {

    public static String fizzBuzz(int num) {
        StringBuilder bldr = new StringBuilder();

        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                bldr.append("fizzbuzz");
            } else if (i % 3 == 0) {
                bldr.append("fizz");
            } else if (i % 5 == 0) {
                bldr.append("buzz");
            } else {
                bldr.append(i);
            }
        }

        return bldr.toString();
    }

    public static void main(String... args) {
        System.out.println("e: " + "12fizz4buzzfizz78fizzbuzz11fizz1314fizzbuzz");
        System.out.println("a: " + fizzBuzz(15));
    }

}
