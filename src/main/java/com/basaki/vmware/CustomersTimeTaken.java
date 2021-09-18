package com.basaki.vmware;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given list of customers with time taken to bill and number of billing
 * machines, calculate minimum time required to bill all the customers
 *
 * customersTimeTaken = [4,2,5,7,9,1,2,3]
 * noOfBillingMachines = 3
 */
public class CustomersTimeTaken {

    public static int findMinimumTimeRequired(int[] customersTimeTaken,
                                              int noOfBillingMachines) {
        Arrays.sort(customersTimeTaken);

        ArrayList<Integer> times = new ArrayList<>();
        int totalTime = 0;
        for (int i = 0; i < customersTimeTaken.length; i++) {
            totalTime += customersTimeTaken[i];
            times.add(i, customersTimeTaken[i]);
        }

        int avg = totalTime / noOfBillingMachines;

        int[] billingMachines = new int[noOfBillingMachines];

        for (int i = 1; i < noOfBillingMachines; i++) {
            int time = avg;
            int nearestTime = 0;
            while (time != 0 || nearestTime != -1) {
                nearestTime = findNearestTime(times, time);
                if (nearestTime > 0) {
                    billingMachines[i] += nearestTime;
                    time -= nearestTime;
                }
            }
        }

        for (Integer t : times) {
            billingMachines[0] += t;
        }

        int max = billingMachines[0];
        for (int i = 1; i < noOfBillingMachines; i++) {
            if (billingMachines[i] > max) {
                max = billingMachines[i];
            }
        }


        return max;
    }

    private static int findNearestTime(ArrayList<Integer> times, int time) {
        int closestMatchIndex = -1;

        for (int i = 0; i < times.size(); i++) {
            if (times.get(i) < time) {
                closestMatchIndex = i;
            } else if (times.get(i) > time) {
                break;
            } else {
                closestMatchIndex = i;
                break;
            }
        }

        if (closestMatchIndex >= 0) {
            return times.remove(closestMatchIndex);
        }

        return closestMatchIndex;
    }
}
