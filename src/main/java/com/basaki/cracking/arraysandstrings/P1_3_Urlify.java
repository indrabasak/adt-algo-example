package com.basaki.cracking.arraysandstrings;

/**
 *
 * 1.4 Write a method to replace all spaces in a string with'%20'.
 * You may assume that the string has sufficient space at the end of the
 * string to hold the additional characters, and that you are given the "true"
 * length of the string.
 */
public class P1_3_Urlify {

    public void replaceSpaces(char[] str, int trueLength) {
        //count of white spaces
        int numOfWhiteSpaces = countChar(str, 0, trueLength, ' ');

        // since a single char, ' ', will be replaced by 3 chars, '%20' - so
        // 2 extra characters
        // lets calculate space required for the new string
        int actualLengthReqd = trueLength + 2 * numOfWhiteSpaces;

        // make sure the array has enough space to hold all the new characters
        assert actualLengthReqd <= str.length;

        //start from the back
        int newIndex = actualLengthReqd - 1;
        int oldIndex = trueLength - 1;
        for (int i = oldIndex; i >= 0; i--) {
            if (str[i] == ' ') { //insert %20
                System.out.println("ws");
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                System.out.println(str[i]);
                // place character form the old place in the array
                // to the new place
                str[newIndex] = str[i];
                newIndex--;
            }
        }

        // put a null char at the end if there is extra space
//        if (actualLengthReqd < str.length) {
//            str[actualLengthReqd] = '\0';
//        }

    }

    private int countChar(char[] str, int start, int end, char c) {
        int count = 0;

        for (int i = start; i < end; i++) {
            if (str[i] == c) {
                count++;
            }
        }

        return count;
    }

    public static void main(String... args) {
        String str = "A B  C        ";

        P1_3_Urlify urlify = new P1_3_Urlify();
        char[] strArray = str.toCharArray();
        urlify.replaceSpaces(strArray, 6);

        System.out.println(str);
        System.out.println(new String(strArray));
    }
}
