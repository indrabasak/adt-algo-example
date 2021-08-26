package com.basaki.algodaily;

import java.util.Arrays;

/**
 * Here's the definition of an anagram: a word, phrase, or name formed by 
 * rearranging the letters of another: such as cinema, formed from iceman.
 *
 * We are given two strings like "cinema" and "iceman" as inputs. 
 * Can you write a method isAnagram(str1, str2) that will return true or 
 * false depending on whether the strings are anagrams of each other?
 *
 * Constraints
 * Length of both the strings <= 100000
 * The strings will contain only alphanumeric characters (a-z , A-Z, 0-9)
 * The strings can be empty
 * Expected time complexity : O(nlogn)
 * Expected space complexity : O(n)
 */
public class IsAnAnagram {
    
    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.trim().length() != str2.trim().length()) {
            return false;
        }

        char[] s1Array = str1.toLowerCase().toCharArray();
        char[] s2Array = str2.toLowerCase().toCharArray();
        
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        
        String newStr1 = new String(s1Array);
        String newStr2 = new String(s2Array);
        
        return newStr1.equals(newStr2);
    }
    
    public static void main(String... args) {
        System.out.println(isAnagram("Mary", "Army"));
        System.out.println(isAnagram("cinema", "iceman"));
        System.out.println(isAnagram("jake", "jay"));
    }
}
