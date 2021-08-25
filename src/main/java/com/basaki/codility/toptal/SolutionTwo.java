package com.basaki.codility.toptal;

import java.lang.Math;
import java.util.Arrays;

/**
 * Compilation successful.
 *
 * Example test:   (3, 2, [2, 1, 1, 0, 1])
 * WRONG ANSWER ("IMPOSSIBLE" is not the correct answer.)
 *
 * Example test:   (2, 3, [0, 0, 1, 1, 2])
 * Output (stderr):
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
 * 	at Solution.solution(Solution.java:44)
 * 	at Exec.run(exec.java:50)
 * 	at Exec.main(exec.java:36)
 * RUNTIME ERROR (tested program terminated with exit code 1)
 *
 * Example test:   (2, 2, [2, 0, 2, 0])
 * Output (stderr):
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
 * 	at Solution.solution(Solution.java:44)
 * 	at Exec.run(exec.java:50)
 * 	at Exec.main(exec.java:36)
 * RUNTIME ERROR (tested program terminated with exit code 1)
 *
 * Detected some errors
 */
class SolutionTwo {

    public String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        int[][] matrix = new int[2][C.length];

        int[] randomIndexes = new int[C.length];
        int randomCount = 0;

        int sumRowU = 0;
        int sumRowL = 0;
        String rowU = "";
        String rowL = "";
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0) {
                matrix[0][i] = 0;
                matrix[1][i] = 0;

            } else if (C[i] == 1) {
                if (sumRowU < sumRowL) {
                    matrix[0][i] = 1;
                } else if (sumRowU > sumRowL){
                    matrix[0][i] = 1;
                    matrix[1][i] = 1;
                } else {
                    int index = (int) ((Math.random() * (1 + 1 - 0)) + 0);
                    randomIndexes[i] = 1;
                    randomCount++;
                    if (index == 0) {
                        matrix[0][i] = 1;
                    } else {
                        matrix[1][i] = 1;
                    }
                }
            } else {
                matrix[i][0] = 1;
                matrix[i][1] = 1;
            }

            rowU +=  matrix[0][i];
            rowL += matrix[1][i];

            sumRowU += matrix[0][i];
            sumRowL += matrix[1][i];
        }



        if (sumRowU == U && sumRowL == L) {
            System.out.println(rowU + "," + rowL);
            return rowU + "," + rowL;
        } /*else if (randomCount < Math.abs(sumRowL - sumRowU)) {
            return "IMPOSSIBLE";
        }*/ else {
            rowU = "";
            rowL = "";
            for (int i = 0; i < C.length; i++) {
                if (randomIndexes[i] == 1) {
                    //switch
                    if (matrix[i][0] == 1) {
                        if ( matrix[0][i] == 1) {
                            matrix[0][i] = 0;
                            matrix[1][0] = 1;
                            sumRowU -= 1;
                            sumRowL += 1;
                        } else {
                            matrix[0][i] = 1;
                            matrix[1][0] = 0;
                            sumRowU += 1;
                            sumRowL -= 1;
                        }
                    }
                }

                if (sumRowU == sumRowL) {
                    break;
                }
            }
        }

        if (sumRowU == sumRowL) {
            rowU = "";
            rowL = "";
            for (int i = 0; i < C.length; i++) {
                rowU += matrix[0][i];
                rowL += matrix[1][i];
            }

            System.out.println(rowU + "," + rowL);
            return rowU + rowL;
        }




        return "IMPOSSIBLE";
    }
}
