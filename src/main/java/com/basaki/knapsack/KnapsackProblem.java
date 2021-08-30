package com.basaki.knapsack;

/**
 * Given weights and values of n items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack.
 * <p>
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
 * which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity, find out the
 * maximum value subset of val[] such that sum of the weights of this subset
 * is smaller than or equal to W. You cannot break an item, either pick the
 * complete item or don’t pick it (0-1 property).
 */
public class KnapsackProblem {

    /**
     * @param a
     * @param b
     * @return the maximum of two integers
     */
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Complexity Analysis:
     * <p>
     * Time Complexity: O(2^n).
     * As there are redundant sub-problems.
     * Auxiliary Space :O(1).
     * As no extra data structure has been used for storing values.
     *
     * @param W
     * @param wt
     * @param val
     * @param n
     * @return the maximum value that can be put in a knapsack of capacity W
     */
    public static int knapsack(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If weight of the nth item is more than Knapsack capacity W,
        // then this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            return knapsack(W, wt, val, n - 1);
        } else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            return max(val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1),
                    knapsack(W, wt, val, n - 1));
        }
    }

    public static int knapsackDynamic(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        int[][] K = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    // 1. nth item included
                    //val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1)

                    // 1. includes value of (i - 1) item
                    int valOne = val[i - 1] + K[i - 1][w - wt[i - 1]];

                    // 2. doesn't include value of (i - 1) item
                    int valTwo = K[i - 1][w];
                    K[i][w] = max(valOne, valTwo);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        return K[n][W];
    }
}
