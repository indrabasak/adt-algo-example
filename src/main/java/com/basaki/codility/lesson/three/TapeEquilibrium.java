package com.basaki.codility.lesson.three;

/**
 * A non-empty array A consisting of N integers is given. Array A represents
 * numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty
 * parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... +
 * A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the
 * first part and the sum of the second part.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * We can split this tape in four places:
 * <p>
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the minimal
 * difference that can be achieved.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
@SuppressWarnings({"squid:S00117"})
class TapeEquilibrium {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int sum = 0;
        for (int value : A) {
            sum += value;
        }

        int currentLeftSum = A[0];
        int currentRightSum = sum - A[0];
        int difference = Math.abs(currentLeftSum - currentRightSum);

        for (int i = 2; i < A.length; i++) {
            currentLeftSum = currentLeftSum + A[i - 1];
            currentRightSum = currentRightSum - A[i - 1];
            int diff = Math.abs(currentLeftSum - currentRightSum);

            if (diff < difference) {
                difference = diff;
            }
        }

        return difference;
    }

    public int solutionOne(int[] A) {
        // write your code in Java SE 8

        int difference = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += A[j];
            }

            int rightSum = 0;
            for (int k = i; k < A.length; k++) {
                rightSum += A[k];
            }

            int diff = Math.abs(leftSum - rightSum);

            if (diff < difference) {
                difference = diff;
            }
        }

        return difference;
    }
}
