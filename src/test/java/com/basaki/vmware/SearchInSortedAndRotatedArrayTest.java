package com.basaki.vmware;

import org.junit.jupiter.api.Test;

import static com.basaki.vmware.SearchInSortedAndRotatedArray.binarySearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInSortedAndRotatedArrayTest {

    @Test
    void search() {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        assertEquals(8, binarySearch(arr, 3));

        int[] arr2 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        assertEquals(-1, binarySearch(arr2, 30));

        int[] arr3 = {30, 40, 50, 10, 20};
        assertEquals(3, binarySearch(arr3, 10));
    }

}
