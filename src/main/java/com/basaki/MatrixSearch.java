package com.basaki;

public class MatrixSearch {

    public static boolean search(int[][] values,
            final int rows,
            final int cols,
            int x) {
        int m = 0;
        int n = cols - 1;

        while (m < rows && n >= 0) {
            if (values[m][n] == x) {
                System.out.println("values[" + m + "][" + n + "] = " + x);
                return true;
            } else if (values[m][n] > x) {
                n--;
            } else {
                m++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int ROWS = 2;
        int COLS = 4;

        int[][] a2 = new int[ROWS][COLS];

        int count = 1;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                a2[row][col] = (row + 1) * (col + 1);
                a2[row][col] = count++;
                System.out.print("values[" + row + "][" + col + "] = "
                        + a2[row][col] + " ");
            }
            System.out.println();
        }

        search(a2, ROWS, COLS, 6);
    }
}
