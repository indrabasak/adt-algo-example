package com.basaki.cracking.sortandsearch;

public class BinarySearch {

    public int binarySearch(int[] a, int x) {
        if (a == null) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low)/2;
            if (a[mid] > x) {
                high = mid - 1;
            } else if (a[mid] < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (a == null || low > high) { // error condition
            return -1;
        }

        int mid = low + (high - low)/2;
        if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
        } else if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid +1 , high);
        } else {
            return mid;
        }
    }

    public static void main(String... args) {
        int[] a = {1, 2, 3, 21, 33, 67};

        BinarySearch ex = new BinarySearch();
        System.out.println(ex.binarySearch(a, 33));
        System.out.println(ex.binarySearch(a, 34));

        System.out.println(ex.binarySearchRecursive(a, 33, 0, a.length - 1));
        System.out.println(ex.binarySearchRecursive(a, 34, 0, a.length - 1));
    }
}
