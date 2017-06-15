package com.basaki.yahoo;

public class MinCoinChange {

    public static void findMinCoinChange(int[] denom, int total) {
        int[] sum = new int[total + 1];
        int[] numOfcoins = new int[total + 1];

        sum[0] = 0;
        numOfcoins[0] = 0;

        int coin = 1;

        for (int p = 1; p <= total; p++) {
            int min = Integer.MAX_VALUE;
            for (int d = 0; d < denom.length; d++) {
                if (p >= denom[d]) {
                    if ((1 + numOfcoins[p - denom[d]]) < min) {
                        int x = (1 + numOfcoins[p - denom[d]]);
                        System.out
                                .println("1 + numOfcoins[p - denom[d]]: " + x);
                        min = 1 + numOfcoins[p - denom[d]];
                        coin = denom[d];
                    }
                }
            }
            sum[p] = coin;
            numOfcoins[p] = min;
        }

        System.out.println("min coins: " + numOfcoins[total]);
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + " ");
        }

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        for (int i = 1; i < numOfcoins.length; i++) {

            System.out.print(numOfcoins[i] + " ");
        }

        System.out.println();
    }

    public static int count(int[] denom, int total) {
        // If total is 0 then there is 1 solution (do not include any coin)
        if (total == 0) {
            return 1;
        }

        // If n is less than 0 then no solution exists
        if (total < 0) {
            return 0;
        }

        // If there are no coins and n is greater than 0, then no solution exist
        if ((denom == null || denom.length == 0) && total >= 1) {
            return 0;
        }

        // return count(denom, )
        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        // return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] denom =
                {25, 25, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5};
        findMinCoinChange(denom, 100);

    }

}
