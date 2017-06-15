package com.basaki.yahoo;

public class RemoveAdjacentDuplicate {

    private static String remove(String value) {
        if (value == null) {
            return "-1";
        }

        value = value.trim();
        if (value.length() <= 1) {
            return "-1";
        }

        char[] buffer = value.toCharArray();
        StringBuilder bldr = new StringBuilder();
        boolean found = false;
        //for (int i = 0; i < buffer.length - 1; i++)
        int i = 0;
        while (i < buffer.length - 1) {
            if (buffer[i] != buffer[i + 1]) {
                bldr.append(buffer[i]);
                if (i == buffer.length - 2) {
                    bldr.append(buffer[i + 1]);
                }
                i++;
            } else {
                found = true;
                i += 2;
            }
        }

        value = bldr.toString();
        if (value.length() > 1 && found) {
            return remove(value);
        } else {
            if (value == null || value.length() == 0) {
                return "-1";
            } else {
                return value;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(remove("ABCCBCBA"));
        System.out.println(remove("AA"));
    }

}
