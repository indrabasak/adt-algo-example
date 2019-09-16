package com.basaki.heap;

import java.util.Arrays;

@SuppressWarnings({"squid:S106"})
public class MinHeap<T extends Comparable<T>> {
    private Object[] heap;

    private int heapSize;

    private int size = 5;

    public MinHeap() {
        heap = new Object[size];
    }

    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();
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
        int oldCapacity = heap.length;
        if (heapSize == oldCapacity) {
            int newCapacity = oldCapacity * 2;
            heap = Arrays.copyOf(heap, newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    public void insert(T data) {
        //new element starts at the last position
        int position = heapSize++;

        //make sure the array is large enough to hold the bew value
        ensureCapacity();

        //now percolate up
        while (position > 0
                && data.compareTo((T) (heap[(position - 1) / 2])) < 0) {
            heap[position] = heap[(position - 1) / 2];
            position = (position - 1) / 2;
        }
        heap[position] = data;
    }

    public void printHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print("[" + heap[i] + "] ");
        }
        System.out.println();
    }

}
