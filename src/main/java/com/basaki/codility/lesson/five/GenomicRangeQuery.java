package com.basaki.codility.lesson.five;

import java.util.HashMap;
import java.util.Map;

/**
 * A DNA sequence can be represented as a string consisting of the letters
 * A, C, G and T, which correspond to the types of successive nucleotides
 * in the sequence. Each nucleotide has an impact factor, which is an integer.
 * Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4,
 * respectively. You are going to answer several queries of the form:
 * What is the minimal impact factor of nucleotides contained in a
 * particular part of the given DNA sequence?
 * <p>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1]
 * consisting of N characters. There are M queries, which are given in
 * non-empty arrays P and Q, each consisting of M integers.
 * The K-th query (0 ≤ K < M) requires you to find the minimal impact factor
 * of nucleotides contained in the DNA sequence between positions P[K]
 * and Q[K] (inclusive).
 * <p>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 * <p>
 * The part of the DNA between positions 2 and 4 contains nucleotides G and
 * C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose
 * impact factor is 4, so the answer is 4.
 * <p>
 * The part between positions 0 and 6 (the whole string) contains all
 * nucleotides, in particular nucleotide A whose impact factor is 1,
 * so the answer is 1.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * <p>
 * that, given a non-empty string S consisting of N characters and two
 * non-empty arrays P and Q consisting of M integers, returns an array
 * consisting of M integers specifying the consecutive answers to all queries.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */
@SuppressWarnings({"squid:S00117", "squid:CommentedOutCodeLine", "squid:S3776"})
class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8

        int[] answers = new int[P.length];

        //A, C, G and T have impact factors of 1, 2, 3 and 4,
        Map<Integer, Integer> impactFactors = new HashMap<>();
        impactFactors.put(0, 1); // A = 1
        impactFactors.put(1, 2); // C = 2
        impactFactors.put(2, 3); // G = 3
        impactFactors.put(3, 4); // T = 4


        // STEP 1 - for each row, count occurrences of each nucleotide,
        // e.g, for DNA sequence CAGCCTA will have the following pattern
        // C = {0, 1, 0, 0}
        // A = {1, 0, 0, 0}
        // G = {0, 0, 1, 0}
        // C = {0, 1, 0, 0}
        // C = {0, 1, 0, 0}
        // T = {0, 0, 0, 1}
        // A = {1, 0, 0, 0}
        int [][] occurrences = new int [S.length()][4];
        for (int i = 0; i < S.length(); i++) {
            char nucleotide = S.charAt(i);
            switch (nucleotide) {
                case 'A':
                    occurrences[i][0] = 1;
                    break;
                case 'C':
                    occurrences[i][1] = 1;
                    break;
                case 'G':
                    occurrences[i][2] = 1;
                    break;
                default:
                    occurrences[i][3] = 1;
                    break;
            }
        }

        // STEP 2 - for each row, add up occurrences of each nucleotide by adding
        // occurrences from previous row to current row
        // now have running sum of each nucleotide for any row
        // e.g, for DNA sequence CAGCCTA will have the following pattern
        //  C {0, 1, 0, 0}
        //  A {1, 1, 0, 0}
        //  G {1, 1, 1, 0}
        //  C {1, 2, 1, 0}
        //  C {1, 3, 1, 0}
        //  T {1, 3, 1, 1}
        //  A {2, 3, 1, 1}
        for(int i = 1; i < S.length(); i++) {
            for(int j = 0; j < 4; j++) {
                occurrences[i][j] += occurrences[i-1][j];
            }
        }

        // check each slice for min by simple subtraction
        for(int i = 0; i < P.length; i++) {
            int minImpact = 5;
            int startPosition = P[i];
            int endPosition = Q[i];

            // if start position is greater than zero, then subtract the values
            // of slice at start position - 1 from slice at end position
            // else just consider the slice at end position
            if (startPosition > 0) {
                for (int j = 0; j < 4; j++) {
                    // if only the nucleotide is present, i.e., value is greater
                    // than zero
                    if (occurrences[endPosition][j] - occurrences[startPosition - 1][j] > 0) {
                        int currentImpact = impactFactors.get(j);
                        if (currentImpact < minImpact) {
                            minImpact = currentImpact;
                        }
                    }
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    // if only the nucleotide is present, i.e., value is greater
                    // than zero
                    if (occurrences[endPosition][j] > 0) {
                        int currentImpact = impactFactors.get(j);
                        if (currentImpact < minImpact) {
                            minImpact = currentImpact;
                        }
                    }
                }
            }

            answers[i] = minImpact;
        }

        return answers;
    }

    public int[] solutionOne(String S, int[] P, int[] Q) {
        // write your code in Java SE 8

        //A, C, G and T have impact factors of 1, 2, 3 and 4,
        Map<Character, Integer> impactFactors = new HashMap<>();
        impactFactors.put('A', 1);
        impactFactors.put('C', 2);
        impactFactors.put('G', 3);
        impactFactors.put('T', 4);

        int[] answers = new int[P.length];

        char[] dnaSequence = S.toCharArray();
        for (int i = 0; i < P.length; i++) {
            int startPosition = P[i];
            int endPosition = Q[i];

            int minImpact = impactFactors.get(dnaSequence[startPosition]);
            for (int j = startPosition; j <= endPosition; j++) {
                int currentImpact = impactFactors.get(dnaSequence[j]);
                if (currentImpact < minImpact) {
                    minImpact = currentImpact;
                }
            }
            answers[i] = minImpact;
        }

        return answers;
    }
}
