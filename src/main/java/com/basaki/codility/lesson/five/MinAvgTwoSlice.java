package com.basaki.codility.lesson.five;

/**
 * A non-empty array A consisting of N integers is given. A pair of
 * integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A
 * (notice that the slice contains at least two elements). The average of a
 * slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by
 * the length of the slice. To be precise, the average equals
 * (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the
 * starting position of the slice with the minimal average. If there is more
 * than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
@SuppressWarnings({"squid:S00117"})
class MinAvgTwoSlice {

    /**
     * Task Score: 100%
     * Correctness: 100%
     * Performance: 100%
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        if (A.length == 2) {
            return 0;
        }

        double minAverage = (A[0] + A[1]) / 2.0;
        int startIndex = 0;

        for (int i = 2; i < A.length; i++) {
            double averageTwoElements = (A[i - 1] + A[i]) / 2.0;
            double averageThreeElements = (A[i - 2] + A[i - 1] + A[i]) / 3.0;

            if (averageThreeElements < minAverage) {
                minAverage = averageThreeElements;
                startIndex = i - 2;
            }

            if (averageTwoElements < minAverage) {
                minAverage = averageTwoElements;
                startIndex = i - 1;
            }
        }

        return startIndex;
    }

    /**
     * Task Score: 60%
     * Correctness: 100%
     * Performance: 20%
     *
     * @param A
     * @return
     */
    public int solutionOne(int[] A) {

        // if A is
        // [4,   2,   2,   5,   1,   5,   8]
        // then the average array should be
        // [0.0, 3.0, 2.7, 3.3, 2.8, 3.2, 3.9]
        // [0.0, 0.0, 2.0, 3.0, 2.5, 3.0, 3.8]
        // [0.0, 0.0, 0.0, 3.5, 2.7, 3.3, 4.2]
        // [0.0, 0.0, 0.0, 0.0, 3.0, 3.7, 4.8]
        // [0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 4.7]
        // [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 6.5]
        // [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

        double[][] avgArray = new double[A.length][A.length];
        double minAverage = 10000;
        int startIndex = -1;
        for (int i = 0; i < A.length; i++) {
            double sum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                double avg = sum / (j - i + 1);
                avgArray[i][j] = avg;
                if (avg < minAverage) {
                    minAverage = avg;
                    startIndex = i;
                }
            }
        }

        return startIndex;
    }
}
