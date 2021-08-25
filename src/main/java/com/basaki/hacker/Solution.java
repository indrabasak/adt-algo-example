package com.basaki.hacker;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int Difference(int[][] arr, int n) {
        int i;
        int sum1=0,sum2=0;
        for(i=0;i<n;i++){
            sum1+=arr[i][i];
            sum2+=arr[i][n-i-1];
        }
        int diff =0;
        diff= sum1 - sum2;
        if(diff < 0){
            diff = 0 - diff;
        }
        return diff;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i,j,res,n;
        n = sc.nextInt();
        int[][] arr= new int[n][n];
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        res = Result.Difference(arr, n);
        System.out.println(res);
    }
}

