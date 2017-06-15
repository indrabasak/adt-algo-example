package com.basaki.heap;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {
    private Object[] fHeap;

    private int fHeapSize;

    private int fSize = 5;

    public MinHeap() {
        fHeap = new Object[fSize];
    }

    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<Integer>();
        heap.insert(16);
        heap.printHeap();
        heap.insert(9);
        heap.insert(11);
        heap.insert(14);
        heap.insert(3);
        heap.insert(5);
        heap.insert(12);
        heap.insert(8);
        heap.insert(7);
        heap.insert(2);
        heap.insert(10);

        heap.printHeap();
    }

    private void ensureCapacity() {
        int oldCapacity = fHeap.length;
        if (fHeapSize == oldCapacity) {
            int newCapacity = oldCapacity * 2;
            fHeap = Arrays.copyOf(fHeap, newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    public void insert(T data) {
        //new element starts at the last position
        int position = fHeapSize++;

        //make sure the array is large enough to hold the bew value
        ensureCapacity();

        //now percolate up
        while (position > 0
                && data.compareTo((T) (fHeap[(position - 1) / 2])) < 0) {
            fHeap[position] = fHeap[(position - 1) / 2];
            position = (position - 1) / 2;
        }
        fHeap[position] = data;
    }

    public void printHeap() {
        for (int i = 0; i < fHeapSize; i++) {
            System.out.print("[" + fHeap[i] + "] ");
        }
        System.out.println();
    }

}
