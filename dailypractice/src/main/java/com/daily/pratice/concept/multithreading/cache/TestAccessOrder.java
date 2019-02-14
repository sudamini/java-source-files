package com.daily.pratice.concept.multithreading.cache.LRUCache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

final class TestAccessOrder {

    public static void main(final String[] args) {

        // order of iteration is undefined
        System.out.println("order of iteration is undefined");
        insertAndPrintValues(new HashMap<>());

         // order of iteration is order of insertion
        System.out.println("order of iteration is order of insertion");
        insertAndPrintValues(new LinkedHashMap<>());

        // sorted by ascending key order
        System.out.println("sorted by ascending key order");
        insertAndPrintValues(new TreeMap<>());

        // order of iteration is access order - from least recently to most recently.
        System.out.println("order of iteration is access order - from least recently to most recently");
        insertAndPrintValues(new LinkedHashMap<>(10,75,true));
    }

    private static void insertAndPrintValues(Map<Integer, String> map) {
        map.put(4,"FOUR");
        map.put(2,"TWO");
        map.put(1,"ONE");
        map.put(3,"THREE");

        System.out.println("Map before accessing keys " + map);
        System.out.println("Accessed a key " +map.get(1));
        System.out.println("Map after accessing keys " + map);
    }
}
