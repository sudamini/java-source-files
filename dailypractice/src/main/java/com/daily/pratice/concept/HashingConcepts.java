package com.daily.pratice.concept;

import java.util.HashSet;
import java.util.Set;

final class HashingConcepts {

    public static void main( final String[] args ){
        reproduceConcurrentModificationException();
    }
    /**
    Throws ConcurrentModificationException because collection is structurally modified outside of iterator's scope
     by calling removeme(test, val) method.
     */
    private static void reproduceConcurrentModificationException() {
        Set<Integer> test = new HashSet<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        /* Foreach loop internally uses an iterator to loop over all elements of set and makes a copy of modcount.
        If at the end of the foreach loop, this copy of modcount does not equal member variable value, it throws
        concurrentmodification exception*/
        for (Integer val:test) {
            test.add(val+1);
            remove_me(test,val);
        }
    }
    private static void remove_me(Set<Integer> test, Integer val ){
        test.remove(val);
    }
}
