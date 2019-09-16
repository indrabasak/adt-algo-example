package com.basaki;

@SuppressWarnings({"squid:S106"})
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
        int rows = 2;
        int cols = 4;

        int[][] a2 = new int[rows][cols];

        int count = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                a2[row][col] = (row + 1) * (col + 1);
                a2[row][col] = count++;
                System.out.print("values[" + row + "][" + col + "] = "
                                         + a2[row][col] + " ");
            }
            System.out.println();
        }

        search(a2, rows, cols, 6);
    }
}
