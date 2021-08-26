package com.basaki.algodaily;

/**
 * write a function that reverses an inputted string without using the
 * built-in Array#reverse method?
 *
 * Let's look at some examples. So, calling:
 *
 * reverseString("jake") should return "ekaj".
 *
 * reverseString("reverseastring") should return "gnirtsaesrever".
 *
 * Constraints
 * Do not use the built-in #reverse() method or [::-1] if Python
 * Ideal solution would run in O(n) time complexity and O(1) space complexity
 */
public class ReverseAString {

    public static String reverseString(String str) {
        // fill in
        if (str == null) {
            return null;
        }

        char[] array = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }

        return new String(array);
    }


    public static void main(String... args) {
        System.out.println("o: timbuktu12");
        System.out.println("e: 21utkubmit");
        System.out.println("a: " + reverseString("timbuktu12"));
    }

}
