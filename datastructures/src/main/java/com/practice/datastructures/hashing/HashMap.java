package com.practice.datastructures.hashing;

public class HashMap {

    private HashNode[] hashNodes;
    private int current_size;
    private static final int DEFAULT_SIZE = 10;

    HashMap() {
        hashNodes = new HashNode[DEFAULT_SIZE];
        current_size = 0;
    }
    class HashNode{
        String key;
        Integer value;
        HashNode next;

        HashNode( String in_key, Integer in_int ) {
            this.key = in_key;
            this.value = in_int;
        }
    }

    int size() {
        return 0;
    }
    boolean isEmpty() {
        return false;
    }
    boolean containsKey(Object key) {
        return false;
    }
    boolean containsValue(Object value) {
        return false;
    }
    Integer get(Object key) {
        return new Integer(0);
    }
    Integer put(String key, Integer value) {
        return new Integer(0);
    }
    /*
    Removes the mapping for the specified key from this map if present. Returns value that this key was associated with
     */
    Integer remove( String  key ) {
        return new Integer(0);
    }
}
