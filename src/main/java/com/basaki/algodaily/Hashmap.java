package com.basaki.algodaily;

import java.util.LinkedList;

/**
 * Arrays are amazing for looking up elements at specific indices as all
 * elements in memory are contiguous, allowing for O(1) or constant time
 * lookups. But often we don't, or can't, perform lookups via indices.
 * Hash maps and hash tables are a way around this, enabling us to lookup
 * via keys instead.
 *
 * Can you implement the Map class from scratch? Only two methods are
 * necessary-- get and set. Many programming languages have a built-in
 * hash or dictionary primitive (like Javascript Objects and {} notation),
 * but we don't want to use that for this exercise.
 */
public class Hashmap {

    public static class Entry {
        private String key;
        private Object value;

        public Entry(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size = 10;
    private LinkedList<Entry>[] map;

    public Hashmap() {
        map = new LinkedList[size];
    }

    public void set(String key, Object val) {
        int index = key.hashCode() % size;
        LinkedList<Entry> list = map[index];

        if (list == null) {
            list = new LinkedList<>();
            list.add(new Entry(key, val));
            map[index] = list;

            return;
        }

        boolean found = false;
        for (Entry e : list) {
            if (e.key.equals(key)) {
                e.value = val;
                found = true;
            }
        }

        if (!found) {
            list.add(new Entry(key, val));
        }
    }

    public Object get(String key) {
        int index = key.hashCode() % size;
        LinkedList<Entry> list = map[index];

        if (list != null) {
            for (Entry e : list) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }

        return null;
    }
}
