package com.basaki;

@SuppressWarnings({"squid:S106", "squid:S00112"})
public class FindNthLargestInAnArray {
    private static void print(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print("[" + values[i] + "]");
        }
        System.out.println();
    }

    private static int partition(int[] values, int low, int high) {
        // Start index for scanning the array
        int left = low;
        // Select middle element of the array as pivot
        int pivotIdx = low + (high - low) / 2;
        // Swap pivot with right most element of the array
        int pivot = values[pivotIdx];
        swap(values, pivotIdx, high);
        pivotIdx = high;
        System.out.println("111");
        print(values);
        /*
         * Pivot will be placed at this index such that all elements to right of
         * it are greater than pivot and all elements to the left of it are
         * smaller than pivot
         */
        int partitionIdx = low;
        while (left < high) {
            System.out.println("left: " + left + " partition index: "
                    + partitionIdx + " pivot: " + pivot);
            /*
             * Initially our partition index is set to leftmost element index in
             * the input array. We keep traversing towards right of the input
             * array and if we find an element lesser than pivot, we swap it
             * with element at partition index and increment partition index
             * else just keep moving right
             */
            if (values[left] < pivot) {
                swap(values, left, partitionIdx);
                System.out.println("222");
                print(values);
                ++partitionIdx;
            }
            ++left;
        }
        /* Place the pivot value at the partition index */
        values[pivotIdx] = values[partitionIdx];
        values[partitionIdx] = pivot;
        return partitionIdx;
    }

    private static void swap(int[] values, int x, int y) {
        int tmp = values[x];
        values[x] = values[y];
        values[y] = tmp;
    }

    /**
     * K is the kth largest element to find. Initial call to this function
     * should be called with 0 and size-1 for low and high respectively.
     **/
    private static int quickSelect(int[] values, int low, int high, int k) {
        if (values == null) {
            throw new RuntimeException("Null array!");
        }

        if (k > values.length) {
            throw new RuntimeException(
                    k
                            + "th largest element is bigger than array size of "
                            + values.length);
        }

        print(values);

        if (low == high) {
            return values[low];
        }

        int pivotIdx = partition(values, low, high);
        System.out.println("^^");
        print(values);

        int sizeOfLeftSubArray = pivotIdx - low + 1;
        /*
         * If'pivotIdx' is greater than 'k', keep looking towards left part
         */
        if (sizeOfLeftSubArray > k) {
            return quickSelect(values, low, pivotIdx - 1, k);
        }
        /*
         * If'pivotIdx' is less than 'k', keep looking towards right part
         */
        else if (sizeOfLeftSubArray < k) {
            return quickSelect(values, pivotIdx + 1, high, k
                    - sizeOfLeftSubArray);
        }
        /* We just found our kth index, return it */
        else {
            return values[pivotIdx];
        }
    }

    public static int findNthLargest(int[] values, int n) {
        return quickSelect(values, 0, values.length - 1, n);
    }

    public static void main(String[] args) {
        int[] values = {8, 7, 21, 60, 45, 2};

        System.out.println(FindNthLargestInAnArray.findNthLargest(values, 4));
    }

}
