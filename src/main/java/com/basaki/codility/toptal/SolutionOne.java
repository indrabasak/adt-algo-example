package com.basaki.codility.toptal;

class SolutionOne {

    public boolean solution(int[] A) {
        // write your code in Java SE 8

        // N is between 5 and 100000
        // each element in A is between 1 and 10000

        // [1, 3, 4, 2, 2, 2, 1, 1, 2] = true
        // drop requests 2 and 5
        int[] sums = new int[A.length];

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        double average = sum / 3;


        return false;
    }
}
