package com.basaki;

import java.util.ArrayList;

@SuppressWarnings({"squid:S106", "squid:S3776", "squid:S1643"})
public class LongestSeqOfOneInAMatrix {

    public static int longestSequenceOfOnes(int[][] matrix) {
        int count = 0;

        ArrayList<String> columns = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            int tempRowSeqCount = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    tempRowSeqCount++;
                } else {
                    if (tempRowSeqCount > count) {
                        count = tempRowSeqCount;
                        tempRowSeqCount = 0;
                    }
                }

                try {
                    String str = columns.get(col);
                    str += matrix[row][col];
                    columns.add(col, str);
                } catch (IndexOutOfBoundsException e) {
                    columns.add(col, Integer.toString(matrix[row][col]));
                }
            }
        }

        for (String column : columns) {
            int tempColSeqCount = 0;
            char[] chars = column.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 1) {
                    tempColSeqCount++;
                } else {
                    if (tempColSeqCount > count) {
                        count = tempColSeqCount;
                        tempColSeqCount = 0;
                    }
                }
            }
        }

        return count;
    }

    public static void print(int[][] matrix) {
        System.out.println(matrix.length);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0}};

        print(matrix);
        System.out.println(longestSequenceOfOnes(matrix));
        int[][] matrix2 = new int[][]
                {
                        {1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0},
                        {1, 0, 0, 1, 0, 0},
                        {1, 0, 0, 1, 0, 0}};
        print(matrix2);
        System.out.println(longestSequenceOfOnes(matrix2));
    }

}
