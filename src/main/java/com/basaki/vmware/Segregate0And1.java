package com.basaki.vmware;

/**
 * You are given an array of 0s and 1s in random order. Segregate 0s on
 * left side and 1s on right side of the array [Basically you have to sort
 * the array]. Traverse array only once.
 *
 * Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 */
public class Segregate0And1 {

    public static void segregate(int[] arr, int n) {
        int count0 = 0;
        for (int i : arr) {
            if (i == 0) {
                count0++;
            }
        }

        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }

        for (int i = count0; i < n; i++) {
            arr[i] = 1;
        }
    }
}
