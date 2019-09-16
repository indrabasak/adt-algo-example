package com.basaki;

@SuppressWarnings({"squid:S106"})
public class Fibonacci {
    public static final int K_MAX = 1000;

    private long[] fLookupTable;

    public Fibonacci() {
        fLookupTable = new long[K_MAX + 1];
        for (int i = 0; i <= K_MAX; i++) {
            fLookupTable[i] = -1;
        }
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();

        System.out.println("Start: Slow -------------------------------");
        System.out.println("Slow fibonacci of 99: " + fib.fibRecursive(6));
        System.out.println("End: Slow -------------------------------");
        System.out
                .println(
                        "Start: Tabilation Bottom Up -------------------------------");
        System.out.println("Fast fibonacci of 82: "
                + fib.fibTabulationBottomUp(82));
        System.out
                .println(
                        "End: Tabilation Bottom Up -------------------------------");
        System.out
                .println(
                        "Start: Tabilation Memoization Top Down -------------------------------");
        System.out.println("Fast fibonacci of 82: "
                + fib.fibMemoizationTopDown(82));
        System.out
                .println(
                        "End: MemoizationTopDown -------------------------------");

        System.out.println("Sum of fibonacci upto 3: " + fib.fibSum(3));
    }

    public int fibRecursive(int num) {
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        return fibRecursive(num - 1) + fibRecursive(num - 2);
    }

    public long fibMemoizationTopDown(int num) {
        if (fLookupTable[num] == -1) {
            if (num <= 1)
                fLookupTable[num] = num;
            else
                fLookupTable[num] = fibMemoizationTopDown(num - 1)
                        + fibMemoizationTopDown(num - 2);
        }

        return fLookupTable[num];
    }

    public long fibTabulationBottomUp(int num) {
        long[] fib = new long[num + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= num; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[num];
    }

    public long fibSum(int num) {
        long[] fib = new long[num + 1];
        fib[0] = 0;
        fib[1] = 1;
        long sum = fib[0] + fib[1];

        for (int i = 2; i <= num; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            sum += fib[i];
        }

        return sum;
    }
}
