package com.basaki;

import java.util.ArrayList;

@SuppressWarnings({"squid:S106"})
public class SensorMonitor {

    private ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        monitor.record(5);
        monitor.record(12);
        monitor.record(3);
        monitor.record(56);
        System.out.println("median: " + monitor.getCurrentMedian());

        monitor = new SensorMonitor();
        monitor.record(5);
        monitor.record(12);
        monitor.record(3);
        monitor.record(56);
        monitor.record(7);
        System.out.println("median: " + monitor.getCurrentMedian());
    }

    public void record(int value) {
        if (list.isEmpty()) {
            list.add(value);
        } else {
            int index = 0;
            while (index < list.size() && list.get(index) < value) {
                index++;
            }

            list.add(index, value);
        }

        for (int x : list) {
            System.out.print(x + " ");
        }

        System.out.println();
    }

    public float getCurrentMedian() {
        float median = 0;

        if (list.size() == 1) {
            System.out.println("** 1");
            median = list.get(0);
        } else if (list.size() % 2 == 0) {

            int index = list.size() / 2;
            System.out.println("** 2 " + index);
            System.out.println(list.get(index) + " " + list.get(index - 1));
            median = ((float) (list.get(index) + list.get(index - 1))) / 2;
        } else {
            System.out.println("** 3");
            int index = list.size() / 2;
            median = list.get(index);
        }

        return median;
    }
}
