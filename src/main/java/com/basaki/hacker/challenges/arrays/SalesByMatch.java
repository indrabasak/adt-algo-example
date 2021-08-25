package com.basaki.hacker.challenges.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 *
 * Example
 *
 *
 * There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
 *
 * Function Description
 *
 * Complete the sockMerchant function in the editor below.
 *
 * sockMerchant has the following parameter(s):
 *
 * int n: the number of socks in the pile
 * int ar[n]: the colors of each sock
 * Returns
 *
 * int: the number of pairs
 * Input Format
 *
 * The first line contains an integer , the number of socks represented in .
 * The second line contains  space-separated integers, , the colors of the socks in the pile.
 *
 * Constraints
 *
 *  where
 * Sample Input
 *
 * STDIN                       Function
 * -----                       --------
 * 9                           n = 9
 * 10 20 20 10 10 30 50 10 20  ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]
 * Sample Output
 *
 * 3
 */
public class SalesByMatch {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer sock : ar) {
            if (map.containsKey(sock)) {
                int count = map.get(sock) + 1;
                if (count %2 == 0) {
                    counter++;
                }
                map.put(sock, count);
            } else {
                map.put(sock, 1);
            }
        }

        return counter;
    }

    public static void main(String... args) {
        List<Integer> socks = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        System.out.println(sockMerchant(socks.size(), socks));
    }
}
