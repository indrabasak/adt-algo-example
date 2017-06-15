package com.basaki;

@SuppressWarnings({"squid:S106"})
public class PyramidSequence {

    public static void print1(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void printPyramid(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int len = i + count;
            int pad = (num + num - 1 - len) / 2;
            for (int k = 0; k < pad; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= len; j++) {
                System.out.print(j);
            }
            System.out.println();
            count++;
        }
    }

    public static void printPyramid2(int num) {
        for (int i = 1; i <= num; i++) {
            int pad = ((num + num - 1) - (i + i - 1)) / 2;
            for (int k = 0; k < pad; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i + (i - 1); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPyramid2(4);
    }
}
