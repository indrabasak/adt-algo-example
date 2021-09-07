package com.basaki.algodaily;

public class DollarSignDeletion {

    public static boolean isDollarDeleteEqual(String[] arr) {
        String cleanedStr = getFinalStr(arr[0]);
        System.out.println("str: " + arr[0]);
        System.out.println("cleaned str: " + cleanedStr);

        return arr[1].equals(cleanedStr);
    }

    private static String getFinalStr(String str) {
        char[] arr = str.toCharArray();
        char[] newArr = new char[findSpaceRequired(str)];

        int index = arr.length - 1;
        int newIndex = newArr.length - 1;

        boolean encounterDollar = false;
        while (index >= 0) {
            if (arr[index] == '$') {
                if (encounterDollar) {
                    encounterDollar = false;
                } else {
                    encounterDollar = true;
                }
            } else {
                if (!encounterDollar) {
                    newArr[newIndex] = arr[index];
                    newIndex--;
                } else {
                    encounterDollar = false;
                }
            }
            index--;
        }

        return new String(newArr);
    }

    private static int findSpaceRequired(String str) {
        char[] arr = str.toCharArray();

        int index = arr.length - 1;

        boolean encounterDollar = false;
        int count = 0;
        while (index >= 0) {
            if (arr[index] == '$') {
                if (encounterDollar) {
                    encounterDollar = false;
                } else {
                    encounterDollar = true;
                }
            } else {
                if (!encounterDollar) {
                    count++;
                } else {
                    encounterDollar = false;
                }
            }
            index--;
        }

        return count;
    }
}
