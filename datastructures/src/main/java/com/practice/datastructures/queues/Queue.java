package com.practice.datastructures.queues;

import com.practice.datastructures.RootLogger;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Queue implements IQueue {

    private Integer[] array_based_queue;
    private final int DEFAULT_SIZE = 10;

    private static Queue instance;
    private int current_size;
    private int front;
    private int rear;

    private static Logger logger;

    static {
        logger = RootLogger.getLogger();
    }

    private Queue() {
        array_based_queue = new Integer[DEFAULT_SIZE];
        front = 0;
        rear = -1;
        current_size = 0;
    }

    static Queue getInstance() {
        instance = new Queue();
        logger.debug( "Created new queue of default size " + instance.default_size() + " and current size " + instance.size() );
        return instance;
    }

    public boolean insert(Integer newItem) {
        boolean ret = false;
        if ( isFull() ) {
            return ret;
        }
        else {
            ++rear;
            array_based_queue[rear] = newItem;
            ++current_size;
            ret = true;
        }
        return ret;
    }

    public boolean remove() {
        boolean ret = false;
        if ( isEmpty() ) {
            return ret;
        } else {
            array_based_queue[front] = null;
            ++front;
            --current_size;
            ret = true;
        }
        return ret;
    }

    public Integer peek() {
        Integer ret = -1;
        if ( !isEmpty() ) {
            ret =  array_based_queue[front];
        }
        return ret;
    }

   public Queue populateQueue() {
        populate();
        return instance;
    }

    protected void print() {
        logger.debug( Arrays.toString(array_based_queue));
    }

    private boolean isFull() {
       return(  size() == DEFAULT_SIZE  );
    }

    private boolean isEmpty() {
        return (size() == 0 );
    }

    protected int default_size() {
        return DEFAULT_SIZE;
    }

    protected int size() {
        return current_size;
    }

    private void populate( ) {
        Random rand = new Random(1);
        Integer temp;
        for ( int i = 0; i <  (DEFAULT_SIZE ) ; i++ ) {
            temp = rand.nextInt(30);
            this.insert( temp );
        }
    }
}
