package com.basaki.knapsack;


import org.junit.jupiter.api.Test;

import static com.basaki.knapsack.KnapsackProblem.knapsack;
import static com.basaki.knapsack.KnapsackProblem.knapsackDynamic;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackProblemTest {

    @Test
    void testKnapsack() {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        assertEquals(220, knapsack(W, wt, val, n));
    }

    @Test
    void testKnapsackDynamic() {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        assertEquals(220, knapsackDynamic(W, wt, val, n));
    }
}
