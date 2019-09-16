package com.basaki.sort;

@SuppressWarnings({"squid:S106", "squid:S3012", "squid:S1871"})
public class MergeSort {

    public static void sort2(int[] values) {
        mergeSort(values, 0, values.length - 1);
    }

    private static void mergeSort(int[] values, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(values, lo, mid);
            mergeSort(values, mid + 1, hi);
            merge(values, lo, mid, hi);
            System.out.print(lo + " " + mid + " " + hi + "          ");
            print(values);
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

    /**
     * A merge sort works recursively. First it divides a data set in half, and
     * sorts each half separately. Next, the first elements from each of the two
     * lists are compared. The lesser element is then removed from its list and
     * added to the final result list.
     * <p>
     * Each recursive call has O(n) runtime, and a total of O(log n) recursions
     * are required, thus the runtime of this algorithm is O(n * log n). A merge
     * sort can also be modified for performance on lists that are nearly sorted
     * to begin with. After sorting each half of the data, if the highest
     * element in one list is less than the lowest element in the other half,
     * then the merge step is unnecessary.
     *
     * @param values
     * @return
     */
    public static int[] sort(int[] values) {
        if (values.length == 1) {
            return values;
        }
        // 13 12 10 4 7 6 3
        // length: 7
        // middle: 7/2 = 3
        // len of left array: (3 - 0) = 3
        // len of right array: 7 - 3 = 4
        int middle = values.length / 2;
        int[] leftSide = new int[middle];
        System.arraycopy(values, 0, leftSide, 0, middle);
        int[] left = sort(leftSide);
        int[] rightSide = new int[values.length - middle];
        System.arraycopy(values, middle, rightSide, 0, values.length - middle);
        int[] right = sort(rightSide);
        int[] result = new int[values.length];
        int dPtr = 0;
        int lPtr = 0;
        int rPtr = 0;
        while (dPtr < values.length) {
            if (lPtr == left.length) {
                result[dPtr] = right[rPtr];
                rPtr++;
            } else if (rPtr == right.length) {
                result[dPtr] = left[lPtr];
                lPtr++;
            } else if (left[lPtr] < right[rPtr]) {
                result[dPtr] = left[lPtr];
                lPtr++;
            } else {
                result[dPtr] = right[rPtr];
                rPtr++;
            }
            dPtr++;
        }

        return result;
    }

    public static void print(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] values =
                {13, 12, 10, 4, 7, 6, 3};
        print(values);
        sort2(values);
        print(values);
    }

}
