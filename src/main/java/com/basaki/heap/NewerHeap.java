package com.basaki.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

@SuppressWarnings({"squid:S106", "squid:S1450", "squid:S1148"})
public class NewerHeap {

    private static int[] arr;

    private static BufferedReader read;

    private static Random randomGenerator;

    private static int size;

    private static int random;

    private static int n;

    private static int left;

    private static int right;

    private static int largest;

    private static void printArray() {

        for (int i = 0; i < size; i++) {
            System.out.println("a[" + i + "] = " + arr[i]);
        }
    }

    public static void buildheap() {
        n = arr.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxheap(i);
        }
    }

    public static void maxheap(int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && arr[left] > arr[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxheap(largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void sort() {

        buildheap();

        for (int i = n; i > 0; i--) {
            exchange(0, i);
            n = n - 1;
            maxheap(0);
        }
    }

    public static void main(String[] args) {

        read = new BufferedReader(new InputStreamReader(System.in));

        randomGenerator = new Random();

        try {
            System.out.print("Please enter array size : ");
            size = Integer.parseInt(read.readLine());

            System.out.print("Please enter the random range : ");
            random = Integer.parseInt(read.readLine());

            // create array
            arr = new int[size];

            // fill array
            for (int i = 0; i < size; i++) {
                arr[i] = randomGenerator.nextInt(random);
            }

            printArray();

            // runtime timer
            long start = System.currentTimeMillis();
            System.out.println("Starting : " + start);

            sort();

            // runtime timer
            System.out.println(System.currentTimeMillis() - start
                    + " millisecond.");

            printArray();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
