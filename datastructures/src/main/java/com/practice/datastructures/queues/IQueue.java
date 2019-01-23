package com.practice.datastructures.queues;

public interface IQueue {

    boolean insert( Integer newItem );
    boolean remove();
    Integer peek();
    Queue populateQueue();

}
