package com.basaki.cracking.arraysandstrings;

//TODO
public class P1_7_RotateMatrix {

    public boolean rotate(int[][] matrix) {
        System.out.println("matrix.length: " + matrix.length
                + " matrix[0].length: " + matrix[0].length);

        if (matrix.length != matrix[0].length) {
            return false;
        }

        int layers = matrix.length/2;
        for (int i = 0; i < layers; i++) {

            int last = 0;
            for (int j = i; j < last; j++) {

            }
        }

        return true;
    }

    public static void main(String... args) {
        P1_7_RotateMatrix ex = new P1_7_RotateMatrix();
        int[][] matrix = new int[2][2];
        System.out.println(ex.rotate(matrix));

        matrix = new  int[3][2];
        System.out.println(ex.rotate(matrix));
    }
}
