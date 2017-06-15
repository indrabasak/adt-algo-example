package com.basaki;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"squid:CommentedOutCodeLine", "squid:S106"})
public class WordBreak {
    private Map<String, String> memoized = new HashMap<>();

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        //        dict.add("apple");
        //        dict.add("pie");
        //        dict.add("i");
        //        dict.add("love");
        //
        //        WordBreak wb = new WordBreak();
        //        System.out.println("version 1, input: 'applepie' output: "
        //                           + wb.segmentStringVer1("applepie", dict));
        //        System.out.println("version 1, input: 'iloveapplepie' output: "
        //                           + wb.segmentStringVer1("iloveapplepie", dict));
        //        System.out.println("version 2, input: 'applepie' output: "
        //                           + wb.segmentStringVer2("applepie", dict));
        //        System.out.println("version 2, input: 'iloveapplepie' output: "
        //                           + wb.segmentStringVer2("iloveapplepie", dict));
        //        System.out.println("version 3, input: 'applepie' output: "
        //                           + wb.segmentStringVer3("applepie", dict));
        //        System.out.println("version 3, input: 'iloveapplepie' output: "
        //                           + wb.segmentStringVer3("iloveapplepie", dict));
        //        System.out.println("^^^^^^^^^^^^^");
        //        System.out
        //                .println("version 3, input: 'iloveapplepieiloveapplepie' output: "
        //                         + wb.segmentStringVer3("iloveapplepieiloveapplepie",
        //                                                dict));

        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        WordBreak wb = new WordBreak();
        System.out.println("version 2, input: 'aaaaaa' output: "
                + wb.segmentStringVer2("aaaaaa", dict));


    }

    public String segmentStringVer1(String input, Set<String> dict) {
        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                if (dict.contains(suffix)) {
                    return prefix + " " + suffix;
                }
            }
        }
        return null;
    }

    public String segmentStringVer2(String input, Set<String> dict) {
        if (dict.contains(input)) {
            return input;
        }

        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = segmentStringVer2(suffix, dict);
                if (segSuffix != null) {
                    return prefix + " " + segSuffix;
                }
            }
        }
        return null;
    }

    public String segmentStringVer3(String input, Set<String> dict) {
        if (dict.contains(input)) {
            return input;
        }

        if (memoized.containsKey(input)) {
            return memoized.get(input);
        }

        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = segmentStringVer3(suffix, dict);
                if (segSuffix != null) {
                    memoized.put(input, prefix + " " + segSuffix);
                    return prefix + " " + segSuffix;
                }
            }
        }
        memoized.put(input, null);
        return null;
    }
}
