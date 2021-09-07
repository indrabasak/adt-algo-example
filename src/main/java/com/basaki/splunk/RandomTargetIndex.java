package com.basaki.splunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * write a program that processes a stream of integers. The stream has a
 * beginning and an end but the number of integers in it (its size) is unknow).
 *
 * When the stream finishes, return one randomly chosen index of the occurrence
 * of the target number.
 *
 * E.g. If the stream consists of [1, 3, 3, 5, 4, 3] and target = 3. We call the
 * process function on each element of the stream:
 *
 * process(4);
 * process(3);
 * process(3);
 * process(5);
 * process(4);
 * process(3);
 *
 * Then the solution is one of the indices 1, 2, 5 randomly.
 *
 * e.g.,
 * solution() == 2
 *
 */
public class RandomTargetIndex {

    private int target;
    int count = 0;
    boolean sendFirst;
    List<Integer> indexes = new ArrayList<>();
    int index = -1;
    boolean hasSeenTarget;
    int countTarget = 0;

    public void start(int target) {
        this.target = target;
    }


    public void process(int num) {
        /*
        if (count == 0) {
            if (num % 2 == 0) {
                System.out.println("--- hello 1");
                sendFirst = true;
            }
        }


        if (num == target) {
            indexes.add(count);
        }

        count++;*/

        if (num == target) {
            countTarget++;
            if (!hasSeenTarget) {
                index = count;
                hasSeenTarget = true;
            } else {
                Random rand = new Random();
                int t = rand.nextInt(countTarget + 1);
                if (t == countTarget) {
                    index = count;
                }
            }
        }

        count++;

    }

    public int end() {
        /*
        if (indexes.size() == 0) {
            return -1;
        }

        if (sendFirst) {
            return indexes.get(0);
        }

        return indexes.get(indexes.size() - 1);
        */

/*
        if (indexes.size() == 0) {
            return -1;
        }

        Random rand = new Random();
        int index = rand.nextInt(indexes.size());

        return indexes.get(index);
        */

        return index;
    }

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
        //1. Keep track of all the indexes (may be) of the target.
        //2. When the function knows he stram has ended, pick a number from the saved indexes.

        // 3. If the first number is even - I will return the first index of the target

        // 4. if it's, return the last ocuurence of the target

        RandomTargetIndex sol = new RandomTargetIndex();
        sol.start(3);
        sol.process(4);
        sol.process(3);
        sol.process(3);
        sol.process(5);
        sol.process(4);
        sol.process(3);
        System.out.println(sol.end());
    }
}
