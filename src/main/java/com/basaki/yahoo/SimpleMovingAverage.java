package com.basaki.yahoo;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"squid:S106"})
public class SimpleMovingAverage {
    public static final int MAX_SIZE = 18 * 60 * 5000;

    private Queue<Double> values = new LinkedList<>();

    private double sum;

    public static void main(String[] args) {
        int[] x = new int[5];
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    public synchronized void addEvent(StockMessage message) {
        sum += message.price;
        values.add(message.price);
        if (values.size() > MAX_SIZE) {
            sum -= values.remove();
        }
    }

    public synchronized double getAverage() {
        if (values.isEmpty()) {
            return 0;
        } else {
            return sum / values.size();
        }
    }

    public static class StockMessage {
        long timestamp; // 8 bytes
        String sysmbol; // 36 + length * 2 = 44 bytes
        double price; // 8 bytes
    }
}
