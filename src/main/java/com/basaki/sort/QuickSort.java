package com.basaki.sort;

public class QuickSort {

    public static void sort(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        quickSort(values, 0, values.length - 1);
    }

    private static void quickSort(int[] values, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        // Get the pivot element from the middle of the list
        int pivot = values[mid];

        int i = lo;
        int j = hi;
        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (values[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (values[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(values, i, j);
                i++;
                j--;
            }
        }

        // Recursion
        if (lo < j) {
            quickSort(values, lo, j);
        }
        if (i < hi) {
            quickSort(values, i, hi);
        }

    }

    private static void swap(int[] values, int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
