package com.practice.datastructures.linkedlists;

public interface ILinkedList<E> {

    boolean insert ( Number e );
    boolean insertAt( Number value, int index );
    E find ( Number e );
    boolean delete( Number e );
    void create();
    int size();
    E get( int index );
    void clear();
    boolean isEmpty();
}
