package com.basaki.algodaily;

/**
 * Sum All Primes: You're given a number n. Can you write a method
 * sumOfAllPrimes that finds all prime numbers smaller than or equal to n,
 * and returns a sum of them?
 *
 * For example, we're given the number 15. All prime numbers smaller than 15 are:
 *
 * 2, 3, 5, 7, 11, 13
 *
 * They sum up to 41, so sumOfAllPrimes(15) would return 41.
 *
 * Constraints
 * n will always be a non zero positive integer <= 100000
 * Expected time complexity : O(nlogn)
 * Expected space complexity : O(n)
 */
public class SumAllPrimes {

    public static int sumOfPrimes(int n) {
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        return sum;
    }

    private static boolean isPrime(int n) {
      // Corner case
        if (n <= 1) {
            return false;
        }

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0) {
                return false;
            }

        return true;
    }
}
