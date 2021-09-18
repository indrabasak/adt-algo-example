package com.basaki.vmware;

/**
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown
 * to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time.
 */
public class SearchInSortedAndRotatedArray {

    public static int binarySearch(int arr[], int key) {
        int pivot = -1;

        int previous = arr[0];
        // find rotation point
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > previous) {
                previous = arr[i];
            } else {
                // we found the rotation index
                pivot = i;
                break;
            }
        }

        int searchIndex = binarySearch(arr, pivot, arr.length - 1, key);

        if (searchIndex == -1) {
            searchIndex = binarySearch(arr, 0, pivot - 1, key);
        }


        return searchIndex;
    }

    private static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

        int mid = (low + high) / 2;
        if (key == arr[mid]) {
            return mid;
        } else if (key > arr[mid]) {
            return binarySearch(arr, (mid + 1), high, key);
        } else {
            return binarySearch(arr, low, (mid - 1), key);
        }
    }
}
