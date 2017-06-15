package com.basaki.yahoo;

import java.util.Iterator;
import java.util.Stack;

public class SkipZeroIterator {
    private int[] values;

    public SkipZeroIterator(int[] data) {
        if (data != null) {
            values = data;
        } else {
            values = new int[0];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]
                {1, 2, 3, 0, 1, 2, -3, 0};
        SkipZeroIterator skiIter = new SkipZeroIterator(data);
        Iterator<Integer> iter = skiIter.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

    }

    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {
        private Stack<Integer> stack = new Stack<Integer>();

        public MyIterator() {
            for (int i = values.length - 1; i >= 0; i--) {
                if (values[i] != 0) {
                    stack.push(values[i]);
                }
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            return stack.pop();
        }

    }

}
