package com.basaki;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicatesInInfiniteRange {

    public static void findDuplicate(int[] input) {
        int pass1 = 0;
        int pass2 = 0;

        for (int i = 0; i < input.length; i++) {
            if (((pass1 >>> input[i]) & 1) != 0) {
                pass2 |= (1 << input[i]);

            } else {
                pass1 |= (1 << input[i]);
            }
        }

        for (int i = 0; i < 20; i++) {
            if (((pass2 >>> i) & 1) != 0) {
                System.out.println(i);
            }
        }
    }

    public static void findDuplicate2(int[] input) {
        Set<Integer> dups = new HashSet<Integer>();
        for (int i = 0; i < input.length; i++) {

            if (!dups.contains(input[i])) {
                for (int j = 0; j < input.length; j++) {
                    if (i != j) {
                        if (input[i] == input[j]) {
                            dups.add(input[i]);
                            break;
                        }
                    }
                }
            }

        }

        for (int x : dups) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void findDuplicate3(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> dups = new HashSet<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                dups.add(input[i]);
            } else {
                map.put(input[i], 1);
            }
        }

        for (int x : dups) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 5, 7, 2, 9, 5, 7};
        findDuplicate2(input);
        findDuplicate3(input);
    }

}
