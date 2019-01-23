package com.practice.datastructures.priorityqueues;

import com.practice.datastructures.queues.Queue;

public interface IPriorityQueue {

    boolean add( PriorityQueue.Node e);
    PriorityQueue.Node remove();
    PriorityQueue.Node peek();

}
