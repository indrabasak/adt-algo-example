package com.basaki.vmware;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.basaki.vmware.CustomersTimeTaken.findMinimumTimeRequired;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomersTimeTakenTest {

    @Test
    void testFindMinimumTimeRequiredWithEqualBuckets() {
        int[] customersTimeTaken = {4, 2, 5, 7, 9, 1, 2, 3};
        int noOfBillingMachines = 3;
        assertEquals(11, findMinimumTimeRequired(customersTimeTaken, noOfBillingMachines));
        int total = 0;
        for (int x : customersTimeTaken) {
            total += x;
        }
        int avg = total/noOfBillingMachines;
        System.out.println("total: " + total + " avg: " + avg);
    }

    @Test
    void testFindMinimumTimeRequiredWithOneUnequalBuckets() {
        int[] customersTimeTaken = {4, 2, 5, 7, 9, 1, 2, 3, 1};
        int noOfBillingMachines = 3;
        assertEquals(12, findMinimumTimeRequired(customersTimeTaken, noOfBillingMachines));
        int total = 0;
        for (int x : customersTimeTaken) {
            total += x;
        }
        int avg = total/noOfBillingMachines;
        System.out.println("total: " + total + " avg: " + avg);
    }

    @Disabled
    @Test
    void testFindMinimumTimeRequiredWithTwoUnequalBuckets() {
        int[] customersTimeTaken = {4, 2, 5, 7, 9, 1, 2, 3, 2};
        int noOfBillingMachines = 3;
        assertEquals(12, findMinimumTimeRequired(customersTimeTaken, noOfBillingMachines));
        int total = 0;
        for (int x : customersTimeTaken) {
            total += x;
        }
        int avg = total/noOfBillingMachines;
        System.out.println("total: " + total + " avg: " + avg);
    }
}
