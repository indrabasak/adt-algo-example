package com.basaki.cracking.sortandsearch;

/**
 * 10.1 Sorted Merge: You are given two sorted arrays, A and B, where A has a
 * large enough buffer at the end to hold B
 */
public class P10_1_SortedMerge {

    public void merge(int[] a, int[] b, int countA, int countB) {
        int countMerged = countA + countB; // length of merged array
        int indexMerged = countMerged - 1; // index of last element in merged array
        int indexA = countA - 1; // index of last element in array A
        int indexB = countB - 1; // index of last element in array B

        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move index
        }
    }

    public static void main(String... args) {
        int[] a = new int[7];
        a[0] = 20;
        a[1] = 31;
        a[2] = 63;

        int[] b = {21, 29, 62};
        System.out.println("A: ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("B: ");
        for (int x : b) {
            System.out.print(x + " ");
        }
        System.out.println();

        P10_1_SortedMerge ex = new P10_1_SortedMerge();
        ex.merge(a, b, 3, 3);

        System.out.println("A: ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
