package com.basaki.sort;

@SuppressWarnings({"squid:S106"})
public class InsertionSort {

    /**
     * Insertion sort is an algorithm that seeks to sort a list one element at a
     * time. With each iteration, it takes the next element waiting to be
     * sorted, and adds it, in proper location, to those elements that have
     * already been sorted.
     * <p>
     * One of the principal advantages of the insertion sort is that it works
     * very efficiently for lists that are nearly sorted initially. Furthermore,
     * it can also work on data sets that are constantly being added to. For
     * instance, if one wanted to maintain a sorted list of the highest scores
     * achieved in a game, an insertion sort would work well, since new elements
     * would be added to the data as the game was played.
     *
     * @param values
     */
    public static void sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int j = i;
            while (j > 0 && values[i] < values[j - 1]) {
                j--;
            }
            int tmp = values[i];
            for (int k = i; k > j; k--) {
                values[k] = values[k - 1];
            }
            values[j] = tmp;
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
