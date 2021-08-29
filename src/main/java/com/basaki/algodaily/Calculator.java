package com.basaki.algodaily;

import java.util.Stack;

public class Calculator {

    public static int calculator(String str) {
        // fill in
        // with solution
        if (str == null) {
            return 0;
        }

        int total = 0;
        Stack<Integer> stack = new Stack<>();
        char[] array = str.toCharArray();
        for (char c : array) {
            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                if (stack.empty()){
                    stack.push(num);
                }
            }

        }

        return total;
    }
}
