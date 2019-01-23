package com.practice.datastructures.queues;

public interface ICircularQueue<T> {

    /* Return newItem if insert is successful, else return a null*/
    T insert( T newItem );

    /* Return removed item if remove is successful, else return a null*/
    T  remove();

    /* Return item at the head of the queue */
    T peek();

    /* Create a new queue of items of type T and default size*/
    CircularQueue<T>  createNewQueue();

}
