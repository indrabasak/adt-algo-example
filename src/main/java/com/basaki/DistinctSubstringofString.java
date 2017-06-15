package com.basaki;

import java.util.Set;
import java.util.TreeSet;

public class DistinctSubstringofString {

    public static void main(String[] args) {
        String input = "abcdqp";
        DistinctSubstringofString d = new DistinctSubstringofString();
        String[] strs = d.getSubStrings1(input);
        //        for (String s : strs)
        //        {
        //            System.out.println(s);
        //        }

    }

    public String[] getSubStrings1(String input) {
        String[] ret = new String[0];
        if (input == null) {
            return ret;
        }

        Set<String> substrs = new TreeSet<String>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j <= input.length(); j++) {
                String sfx = input.substring(i, j);
                System.out.println(j + " " + sfx);
                substrs.add(sfx);
            }
            System.out.println("=========");
        }

        ret = substrs.toArray(ret);

        return ret;
    }

}
