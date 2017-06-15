package com.basaki.concurrency;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class MyStripedMap<K, V> {
    /*
     * The default initial capacity for this table, used when not otherwise
     * specified in a constructor.
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * The default load factor for this table, used when not otherwise specified
     * in a constructor.
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * The default concurrency level for this table, used when not otherwise
     * specified in a constructor.
     */
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;

    private static class Node<K, V> {
        final int hash;
        final K key;
        volatile V value;
        volatile Node<K, V> next;

        Node(int hash, K key, V val, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = val;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }

        public final String toString() {
            return key + "=" + value;
        }
    }

    private static final class Segment<K, V> extends ReentrantLock implements
            Serializable {
        private static final long serialVersionUID = 1L;
        final float fLoadFactor;
        transient volatile int fCount;
        transient volatile Node<K, V>[] fTable;
        transient int fThreshold;

        @SuppressWarnings("unchecked")
        Segment(int initialCapacity, float loadFactor) {
            fTable = new Node[initialCapacity];
            fLoadFactor = loadFactor;
            fThreshold = (int) (fTable.length * fLoadFactor);
        }

        public V get(Object key, int hash) {
            if (fCount != 0) {
                Node<K, V>[] tab = fTable;
                int index = hash & (tab.length - 1);
                Node<K, V> head = tab[index];

                Node<K, V> current = head;
                while (current != null) {
                    if (current.hash == hash && key.equals(current.key)) {
                        V val = current.value;
                        if (val != null) {
                            return val;
                        }
                        return readValueUnderLock(current); // recheck
                    }
                    current = current.next;
                }
            }

            return null;
        }

        /**
         * Reads value field of an entry under lock. Called if value field ever
         * appears to be null. This is possible only if a compiler happens to
         * reorder a HashEntry initialization with its table assignment, which
         * is legal under memory model but is not known to ever occur.
         */
        private V readValueUnderLock(Node<K, V> node) {
            lock();
            try {
                return node.value;
            } finally {
                unlock();
            }
        }

        public V put(K key, int hash, V value, boolean onlyIfAbsent) {
            lock();
            try {
                int count = fCount;
                if (count++ > fThreshold) {
                    // ensure capacity
                    rehash();
                }

                Node<K, V>[] tab = fTable;
                int index = hash & (tab.length - 1);
                Node<K, V> head = tab[index];
                Node<K, V> current = head;
                while (current != null
                        && (current.hash != hash || !key.equals(current.key))) {
                    current = current.next;
                }

                V oldValue;
                if (current != null) {
                    oldValue = current.value;
                    if (!onlyIfAbsent) {
                        current.value = value;
                    }
                } else {
                    oldValue = null;
                    // ++modCount;
                    tab[index] = new Node<K, V>(hash, key, value, head);
                    fCount = count; // write-volatile
                }
                return oldValue;
            } finally {
                unlock();
            }
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            Node<K, V>[] oldTable = fTable;
            int oldCapacity = oldTable.length;
            int newCapacity = oldCapacity << 1;

            Node<K, V>[] newTable = new Node[newCapacity];
            fThreshold = (int) (newCapacity * fLoadFactor);

            int sizeMask = newTable.length - 1;
            for (int i = 0; i < oldCapacity; i++) {
                // We need to guarantee that any existing reads of old Map can
                // proceed. So we cannot yet null out each bin.
                Node<K, V> head = oldTable[i];

                if (head != null) {
                    Node<K, V> next = head.next;
                    int idx = head.hash & sizeMask;

                    // Single node on list
                    if (next == null) {
                        newTable[idx] = head;
                    } else {
                        // Reuse trailing consecutive sequence at same slot
                        Node<K, V> lastRun = head;
                        int lastIdx = idx;
                        for (Node<K, V> last = next; last != null; last = last.next) {
                            int k = last.hash & sizeMask;
                            if (k != lastIdx) {
                                lastIdx = k;
                                lastRun = last;
                            }
                        }
                        newTable[lastIdx] = lastRun;

                        // Clone all remaining nodes
                        for (Node<K, V> p = head; p != lastRun; p = p.next) {
                            int k = p.hash & sizeMask;
                            Node<K, V> n = newTable[k];
                            newTable[k] = new Node<K, V>(p.hash, p.key,
                                    p.value, n);
                        }
                    }
                }
            }
            fTable = newTable;
        }

    }

}
