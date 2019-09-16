package com.basaki;

@SuppressWarnings({"squid:S1118"})
public class MedianOfTwoSortedArray {

    public static float findMedian(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;
        //create a joined sorted list
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                answer[k] = a[i];
                i++;
            } else {
                answer[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            answer[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            answer[k] = b[j];
            j++;
            k++;
        }

        float median = 0;
        if (answer.length == 1) {
            median = answer[0];
        } else if (answer.length % 2 == 0) {
            //for even length
            int index = answer.length / 2;
            median = ((float) (answer[index] + answer[index - 1])) / 2;
        } else {
            //for odd length
            int index = answer.length / 2;
            median = answer[index];
        }

        return median;
    }
}
