package com.basaki;

@SuppressWarnings({"squid:S106", "squid:S4165"})
public class SortZeroAndNonzeroIntegerArray {

    public static int[] sort(int[] input) {
        int i = 0;
        int j = input.length - 1;
        while (i < j) {
            while (input[i] == 0) {
                i++;
            }

            while (input[j] != 0) {
                j--;
            }

            if (i < j) {
                swap(input, i, j);
            }
        }

        return input;
    }

    private static void swap(int[] letters, int i, int j) {
        if (i >= 0 && i < letters.length && j >= 0 && j < letters.length) {
            int tmp = letters[i];
            letters[i] = letters[j];
            letters[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] input = {0, 2, 3, 0, 0, 0, 7, 11, 0, 0};
        input = sort(input);

        for (int i : input) {
            System.out.print(i + " ");
        }

    }

}
