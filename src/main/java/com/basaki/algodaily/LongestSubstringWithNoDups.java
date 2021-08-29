package com.basaki.algodaily;

import java.util.Arrays;

/**
 * Given a string of characters, can you find the longest
 * substring of the string that has no repeating characters?
 */
public class LongestSubstringWithNoDups {

    public static final int ALPHABET_LEN = 26;

    //this assumes that we have only lower case characters in input
    public static int findLongest(String str) {
        int max = 0;
        boolean[] letterPos = new boolean[ALPHABET_LEN];
        int[] indexPos = new int[ALPHABET_LEN];
        //Arrays.fill(indexPos, -1 );

        // t h i s i s a t e s t
        // 0 1 2 3 4 5 6 7 8 9 10
        // letter   index   count
        // t        0       1
        // h        1       2
        // i        2       3
        // s        3       4
        // max = count = 4
        // count =  (4 - 1) - 2 = 1
        // i        4       2
        // max = 4
        // count = (5 - 1) - 3 = 1
        // s        5       3
        // a        6       4
        // t        7       5
        // e        8       6
        // max = 6
        // count = (9 - 1) - 7 = 1
        // t        9       2
        char[] chars = str.toCharArray();
        int count = 0;
        int lastPos = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = Character.getNumericValue(chars[i]) - Character.getNumericValue('a');
            if (letterPos[index]) {
                if (count > max) {
                    max = count;
                }

                System.out.println("count before: " + count);
                // last position of the duplicate character
                int x = indexPos[index];


                // new count = current - 1 - last position of duplicate character
                count =  (i - 1) - x;

                // cleanup
                for (int j = lastPos; j <= x; j++) {
                    //System.out.print(chars[j] + " ");
                    int k = Character.getNumericValue(chars[j]) - Character.getNumericValue('a');
                    letterPos[k] = false;
                    indexPos[k] = -1;
                }
                //System.out.println();

                lastPos = x + 1;
                count++;
                //System.out.println("i: " + i + " x: " + x + " after match count: " + count + " - " + chars[i]);
                letterPos[index] = true;
                indexPos[index] = i;
            } else {
                count++;
                System.out.println("count: " + count  + " - " + chars[i]);
                letterPos[index] = true;
                indexPos[index] = i;
            }
        }

        if (count > max) {
            max = count;
        }

        return max;
    }
}
