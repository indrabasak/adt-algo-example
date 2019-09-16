package com.basaki;

@SuppressWarnings({"squid:S106", "squid:S3012"})
public class LongestSequenceWithMinDiff {

    public static int findLongestSequence(int[] values) {
        if (values == null || values.length == 0) {
            return -1;
        }

        int[] data = new int[values.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = values[i];
        }

        mergeSort(data, 0, data.length - 1);
        print(data);

        int count = 0;
        int minIdx = 0;
        int tempCount = 1;

        for (int i = 0; i < data.length; i++) {
            int diff = data[i] - data[minIdx];
            if (diff > 1) {
                minIdx = i;
                if (tempCount > count) {
                    count = tempCount;
                }

                tempCount = 1;
            } else {
                tempCount++;
            }
        }

        if (tempCount > count) {
            count = tempCount;
        }

        return count;
    }

    public static void print(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] values, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(values, lo, mid);
            mergeSort(values, mid + 1, hi);
            merge(values, lo, mid, hi);
        }
    }

    private static void merge(int[] values, int lo, int mid, int hi) {
        int[] copy = new int[values.length];

        for (int i = lo; i <= hi; i++) {
            copy[i] = values[i];
        }

        int i = lo;
        int j = mid + 1;
        int k = lo;

        while (i <= mid && j <= hi) {
            if (copy[i] <= copy[j]) {
                values[k] = copy[i];
                i++;
            } else {
                values[k] = copy[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            values[k] = copy[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] values =
                {6, 10, 6, 7, 8, 9, 0};
        System.out.println(findLongestSequence(values));
    }

}
