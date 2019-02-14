package com.daily.pratice.concept.multithreading.cache.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap {
        private final int maxEntries;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;
        private static final float DEFAULT_LOAD_FACTOR = 0.75f;

        /*public LRUCache(int initialCapacity,
                        float loadFactor,
                        int maxEntries) {
            super(initialCapacity, loadFactor, true);
            this.maxEntries = maxEntries;
        }

        public LRUCache(int initialCapacity,
                        int maxEntries) {
            this(initialCapacity, DEFAULT_LOAD_FACTOR, maxEntries);
        }*/

        public LRUCache(int maxEntries) {
            super(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR,true);
            this.maxEntries = maxEntries;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maxEntries;
        }
    }

