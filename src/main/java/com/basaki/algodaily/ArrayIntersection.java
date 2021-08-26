package com.basaki.algodaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a function that takes two arrays as inputs and returns to us their
 * intersection? We can call the method intersection. Let's return the
 * intersection of the two inputs in the form of an array. As a reminder,
 * the definition of an intersection of two sets A and B is the set
 * containing all elements of A that also belong to B (or equivalently,
 * all elements of B that also belong to A).
 */
public class ArrayIntersection {

    public static Integer[] arrayIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set2.add(arr2[i]);
        }

        List<Integer> intersection = new ArrayList<>();
        for (Integer s : set1.toArray(new Integer[0])) {
            if (set2.contains(s)) {
                intersection.add(s);
            }
        }

        return intersection.toArray(new Integer[0]);
    }
}
