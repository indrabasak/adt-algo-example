package com.basaki.sort;

import java.util.ArrayList;

public class HeapSort<T extends Comparable<T>> {

    public static void main(String[] args) {
        HeapSort<Integer> hsort = new HeapSort<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(7);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(21);
        list.add(9);
        Integer[] data = new Integer[list.size()];
        data = list.toArray(data);
        hsort.print(data);
        hsort.sort(data);
        hsort.print(data);
        int x = 7 / 2;
        int y = (int) 7.5 / 2;
        //System.out.println(x);
        //System.out.println(y);

    }

    public void sortx(T[] data) {
        int heapSize = data.length;
        for (int i = heapSize / 2; i >= 0; i--) {
            buildHeap(data, heapSize, i);
        }

        for (int i = heapSize - 1; i > 0; i--) {
            T tmp = data[i];
            data[i] = data[0];
            data[0] = tmp;
            buildHeap(data, i, 0);
        }
    }

    private void buildHeap(T[] data, int heapSize, int position) {
        T value = data[position];
        while (position < heapSize) {
            int childPos = 2 * position + 1;
            if (childPos < heapSize) {
                if ((childPos + 1 < heapSize)
                        && (data[childPos + 1].compareTo(data[childPos]) < 0)) {
                    childPos = childPos + 1;
                }

                if (value.compareTo(data[childPos]) > 0) {
                    data[position] = value;
                    return;
                } else {
                    data[position] = data[childPos];
                }
            } else {
                data[position] = value;
                return;
            }
        }
    }

    public void sort(T[] data) {

        buildHeap(data);
        System.out.println("====================================");
        print(data);
        int n = data.length - 1;
        for (int i = n; i > 0; i--) {
            System.out.println("^^^^^i:" + i);
            swap(data, 0, i);
            print(data);
            n = n - 1;
            maxHeap(data, n, 0);
        }
    }

    private void buildHeap(T[] data) {
        int max = data.length - 1;
        System.out.println("max: " + max + " max/2: " + max / 2);
        for (int i = max / 2; i >= 0; i--) {
            System.out.println("----i:" + i);
            maxHeap(data, max, i);
        }
    }

    private void maxHeap(T[] data, int max, int position) {
        int left = 2 * position + 1;
        int right = 2 * position + 2;
        int smallest = position;

        if (left <= max && data[left].compareTo(data[position]) > 0) {
            smallest = left;
        } else {
            smallest = position;
        }

        if (right <= max && data[right].compareTo(data[smallest]) > 0) {
            smallest = right;
        }

        if (smallest != position) {
            swap(data, position, smallest);
            System.out.println("&&&");
            print(data);
            maxHeap(data, max, smallest);
        }
    }

    private void buildHeap3(T[] data) {
        int size = data.length;
        for (int i = size / 2; i >= 0; i--) {
            percolatingDown(data, size, i);
        }
    }

    private void percolatingDown(T[] data, int size, int k) {
        T tmp = data[k];
        int child;
        int left = 2 * k;
        int right = 2 * k + 1;
        int smallest = k;

        for (; 2 * k < size; k = child) {
            child = 2 * k;

            if (child < size && child != size && data[child].compareTo(
                    data[child + 1]) > 0) {
                child++;
            }

            if (child < size && child != size && tmp.compareTo(
                    data[child]) > 0) {
                data[k] = data[child];
            } else {
                break;
            }

        }
        data[k] = tmp;
    }

    public void sort3(T[] data) {
        int size = data.length - 1;
        buildHeap3(data);
        System.out.println("^^^^");
        print(data);
        for (int i = size; i > 0; i--) {
            T tmp = data[i]; //move top item to the end of the heap array
            data[i] = data[0];
            data[0] = tmp;
            size--;
            percolatingDown(data, size, 0);
        }
/*       for(int k = 0; k < data.length-1; k++)
          data[k] = heap[heap.length - 1 - k];*/
    }

    private void swap(T[] data, int i, int j) {
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public void print(T[] data) {
        //        for (T i : data)
        //        {
        //            System.out.print("[" + i + "]");
        //        }
        for (int i = 0; i < data.length; i++) {
            System.out.print("[" + data[i] + "]");
        }
        System.out.println();
    }

}
