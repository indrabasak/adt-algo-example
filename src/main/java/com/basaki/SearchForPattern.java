package com.basaki;

@SuppressWarnings({"squid:S106", "squid:S1854"})
public class SearchForPattern {

    public static void findIndexes() {
        String searchableString = "don’t be evil.being evil is bad";
        String keyword = "be";

        int index = searchableString.indexOf(keyword);
        while (index >= 0) {
            System.out.println("Index : " + index);
            index = searchableString.indexOf(keyword, index + keyword.length());
        }

    }

    public static void main(String[] args) {
        SearchForPattern srchPtrn = new SearchForPattern();
        System.out.println(srchPtrn.bruteForceSearch(
                "don’t be evil.being evil is bad", "be"));
        System.out.println(srchPtrn.kmpSearch("abcabdabcabeabcabdabcabd",
                                              "abcabdabc"));

    }

    /**
     * A trivial but very general problem-solving technique that consists of
     * systematically enumerating all possible candidates for the solution and
     * checking whether each candidate satisfies the problem's statement.
     * <p>
     * Efficiency: O(mn)
     * <p>
     * The BFSA has the following characteristics:
     * <ol>
     * <li>The pattern is not pre-processed.</li>
     * <li>The algorithm compares from left to right character by
     * character.</li>
     * <li>The worst time efficiency is Θ(mn) comparisons.</li>
     * <li>The algorithm returns the first occurrence of the pattern.</li>
     * </ol>
     * <pr>
     * https://weblogs.java.net/blog/potty/archive/2012/04/19/string-searching
     * -algorithms-part-i
     *
     * @param text
     * @param pattern
     * @return
     */
    public int bruteForceSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        char[] textLetters = text.toCharArray();
        char[] patternLetters = pattern.toCharArray();

        for (int i = 0; i < n - m; i++) {
            int j = 0;
            while (j < m && textLetters[i + j] == patternLetters[j]) {
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Pre processes the pattern array based on proper prefixes and proper
     * suffixes at every position of the array
     *
     * @param pattern word that is to be searched in the search string
     * @return partial match table which indicates
     */
    public int[] preProcessPattern(char[] pattern) {
        int i = 0;
        int j = -1;
        int ptrnLen = pattern.length;
        int[] b = new int[ptrnLen + 1];

        b[i] = j;
        while (i < ptrnLen) {
            while (j >= 0 && pattern[i] != pattern[j]) {
                // if there is mismatch consider next widest border
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }
        for (int k = 0; k < b.length; k++) {
            System.out.print(b[k] + " ");
        }
        System.out.println();
        return b;
    }

    /**
     * Knuth-Morris-Pratt algorithm has the following characteristics:
     * <ul>
     * <li>The algorithm compares from left to right.</li>
     * <li>The algorithm preprocess the pattern.</li>
     * <li>The preprocessing phase time efficiency is O(m).</li>
     * <li>The searching phase time efficiency is O(m+n).</li>
     * <li>The algorithm accomplish at most 2n - 1 comparisons.</li>
     * </ul>
     * <p>
     * Advantages
     * <li>Fast.</li>
     * <li>Simple.</li>
     * <li>It is good for processing large files.</li>
     * <li>Avoid comparisons with elements of 'B' that have previously been
     * involved in comparison with some element of the pattern.</li>
     * <p>
     * Disadvantages
     * <ul>
     * <li>Chances of mismatch increases with big sized alphabets.</li>
     * </ul>
     *
     * @param text
     * @param pattern
     * @return
     */
    public int kmpSearch(String txt, String pattern) {
        char[] text = txt.toCharArray();
        char[] ptrn = pattern.toCharArray();
        // pattern and text lengths
        int ptrnLen = ptrn.length;
        int txtLen = text.length;

        // initialize new array and preprocess the pattern
        int[] b = preProcessPattern(ptrn);

        int i = 0;
        int j = 0;
        // pattern and tex
        while (i < txtLen) {
            while (j >= 0 && text[i] != ptrn[j]) {
                j = b[j];
            }
            i++;
            j++;

            // a match is found
            if (j == ptrnLen) {
                j = b[j];
                return i - ptrnLen;
            }
        }
        return -1;
    }

    public int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] occurrence;
        occurrence = new int[256];
        for (int c = 0; c < 256; c++) {
            occurrence[c] = -1;
        }

        for (int j = 0; j < pattern.length(); j++)
            occurrence[pattern.charAt(j)] = j;

        int skip;
        for (int i = 0; i <= n - m; i++) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {

                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - occurrence[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0)
                return i;
        }
        return n;
    }

    public void matches(String searchMe, String findMe) {
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = true;
                System.out.println(searchMe.substring(i, i + findMeLength));
                break;
            }
        }
        if (!foundIt)
            System.out.println("No match found.");

    }

}
