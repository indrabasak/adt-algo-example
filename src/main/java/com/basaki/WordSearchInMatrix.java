package com.basaki;

import java.util.ArrayList;

@SuppressWarnings({"squid:S106"})
public class WordSearchInMatrix {

    public static int search(char[][] matrix, char[] textToFind) {
        ArrayList<StringBuilder> columns = new ArrayList<StringBuilder>();
        String text = new String(textToFind);
        int count = 0;

        for (int row = 0; row < matrix.length; row++) {
            StringBuilder word = new StringBuilder();
            for (int col = 0; col < matrix[row].length; col++) {
                word.append(matrix[row][col]);

                //adding column characters
                try {
                    StringBuilder bldr = columns.get(col);
                    bldr.append(matrix[row][col]);
                } catch (IndexOutOfBoundsException e) {
                    StringBuilder bldr = new StringBuilder();
                    bldr.append(matrix[row][col]);
                    columns.add(col, bldr);
                }
            }

            String wordStr = word.toString();
            int index = wordStr.indexOf(text);
            if (index != -1) {
                count++;
            }
        }

        for (StringBuilder bldr : columns) {
            String wordStr = bldr.toString();
            int index = wordStr.indexOf(text);
            if (index != -1) {
                count++;
            }
        }

        return count;
    }

    public static void print(char[][] matrix) {
        System.out.println(matrix.length);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]
                {
                        {'A', 'I', 'N', 'D', '0', '0'},
                        {'B', 'N', 'S', '1', '0', '0'},
                        {'C', 'D', '0', '1', '0', '0'}};

        print(matrix);
        char[] text =
                {'I', 'N', 'D'};
        System.out.println(search(matrix, text));
    }

}
