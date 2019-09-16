package com.basaki.sort;

@SuppressWarnings({"squid:S106"})
public class BubbleSort {

    /**
     * The idea is to pass through the data from one end to the other, and swap
     * two adjacent elements whenever the first is greater than the last. Thus,
     * the smallest elements will "bubble" to the surface. This is O(n�)
     * runtime, and hence is very slow for large data sets. The single best
     * advantage of a bubble sort, however, is that it is very simple to
     * understand and code from memory. Additionally, it is a stable sort that
     * requires no additional memory, since all swaps are made in place.
     *
     * @param values
     */
    public static void sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int tmp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = tmp;
                }
            }
            print(values);
        }
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
        sort(values);
        print(values);

    }

}
