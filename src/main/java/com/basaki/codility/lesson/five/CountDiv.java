package com.basaki.codility.lesson.five;

/**
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers
 * within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3,
 * because there are three numbers divisible by 2 within the range [6..11],
 * namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */
@SuppressWarnings({"squid:S00117"})
class CountDiv {

    /**
     * Task Score: 100%
     * Correctness: 100%
     * Performance: 100%
     * Complexity: O(1)
     *
     * @param A
     * @param B
     * @param K
     * @return
     */
    public int solution(int A, int B, int K) {
        // When A % K == 0, the answer can be given by (B - A) / K + 1.
        // When A % K != 0, the answer can be given by (B - (A - A % K)) / K.

        if (A % K == 0) {
            return (B - A)/K  + 1;
        }

        return (B - (A - A % K))/K;
    }

    /**
     * Task Score: 50%
     * Correctness: 100%
     * Performance: 0%
     * Complexity: O(B-A)
     *
     * @param A
     * @param B
     * @param K
     * @return
     */
    public int solutionOne(int A, int B, int K) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                count++;
            }
        }

        return count;
    }

}
