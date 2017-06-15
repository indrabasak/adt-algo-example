package com.basaki;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int[] val1 = {1, 2, -5, 4, 7, -2};
        int[] val2 = {1, 5, -3, 4};
        MaximumSubArraySum msub = new MaximumSubArraySum();
        //        System.out.println(msub.maxSum(val1));
        //        System.out.println(msub.maxSum(val2));
        //
        msub.maxSum1(val1);
        msub.maxSum1(val2);
        //

        msub.maxSum2(val1);
        msub.maxSum2(val2);

        int[] val3 = {45, 91, -51, -3, 4};
        msub.maxSum2(val3);
    }
    
    /*
     * def msum2(a):
    bounds, s, t, j = (0,0), -float('infinity'), 0, 0
    
    for i in range(len(a)):
        t = t + a[i]
        if t > s: bounds, s = (j, i+1), t
        if t < 0: t, j = 0, i+1
    return (s, bounds)
     */

    public int maxSum1(int[] values) {
        int sum = 0, maxSum = 0;
        int index1 = 0;
        int index2 = 0;
        //Integer.MIN_VALUE;

        for (int i = 0; i < values.length; sum = 0, i++) {
            for (int j = i; j < values.length; j++) {
                sum = sum + values[j];

                if (sum > maxSum) {
                    maxSum = sum;
                    index1 = i;
                    index2 = j;
                }
            }
        }

        System.out.println("max sum: " + maxSum + " from index: " + index1
                + " to index: " + index2);
        return maxSum;
    }

    public int maxSum2(int[] values) {
        int t = 0;
        int s = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int j = 0;

        for (int i = 0; i < values.length; i++) {
            t = t + values[i];

            if (t > s) {
                s = t;
                startIndex = j;
                endIndex = i;
            }

            if (t < 0) {
                t = 0;
                j = i + 1;
            }
        }

        System.out.println("** sum: " + s + " from index: " + startIndex
                + " to index: " + endIndex);

        return s;
    }

    public int maxSum(int[] values) {
        int maxEndingHere = 0;
        int maxSoFar = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < values.length; i++) {
            maxEndingHere = maxEndingHere + values[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            /*
             * Do not compare for all elements. Compare only�� ��������when�
             * max_ending_here > 0
             */
            else if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

        }

        return maxSoFar;
    }

}
