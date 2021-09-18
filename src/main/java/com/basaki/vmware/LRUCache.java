package com.basaki.vmware;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * The LRU caching scheme is to remove the least recently used frame
 * when the cache is full and a new page is referenced
 * which is not there in the cache.
 *
 * O(1) lookup and O(n) insertion
 * Reference: https://www.geeksforgeeks.org/lru-cache-implementation/
 */
public class LRUCache {

    // stores keys of cache
    private Deque<Integer> cache;

    // for fast lookup of keys
    private Set<Integer> cacheSet;

    // maximum capacity of cache
    private int maxCapacity;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        cache = new LinkedList<>();
        cacheSet = new HashSet<>();
    }

    public void refer(int page) {
        // if cache doesn't have the page key
        if (!cacheSet.contains(page)) {
            // remove the oldest page
            if (cache.size() == maxCapacity) {
                int last = cache.removeLast();
                cacheSet.remove(last);
            }
        } else {
            // remove the page even if it's there since
            // it can be the oldest page
            cache.remove(page);
        }

        // add the page
        cache.push(page);
        cacheSet.add(page);
    }

    // display keys in the cache
    public void display() {
        StringBuilder bldr = new StringBuilder();
        for (Integer page : cache) {
            bldr.append(page).append(" ");
        }

        System.out.println(bldr.toString());
    }

    public int[] print() {
        List<Integer> values = new ArrayList<>();
        values.addAll(cache);

        return values.stream().mapToInt(i->i).toArray();
    }

    public static void main(String... args) {
        LRUCache cache = new LRUCache(3);
        cache.refer(3);
        cache.refer(2);
        cache.refer(1);
        cache.display();
        cache.refer(5);
        cache.display();
        cache.refer(2);
        cache.display();
    }
}
