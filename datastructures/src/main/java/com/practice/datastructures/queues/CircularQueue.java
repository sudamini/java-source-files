package com.practice.datastructures.queues;

import com.practice.datastructures.RootLogger;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class CircularQueue<T> implements ICircularQueue<T> {

    private int front;
    private int rear;
    private boolean circular_queue;
    private T[] array_based_circular_queue;

    private static final int DEFAULT_SIZE = 4;
    private CircularQueue<T> instance;
    private int current_size;
    private static Logger logger;

    static {
        logger = RootLogger.getLogger();
    }

    public CircularQueue () {
        array_based_circular_queue = (T[]) new Integer[DEFAULT_SIZE];
        front = 0;
        rear = -1;
        circular_queue = false;
        current_size = 0;
        logger.debug( "Created new queue of default size " + getDefaultSize() + " and current size " + getCurrent_size());
    }



    public CircularQueue<T> createNewQueue() {
        return new CircularQueue<T>();
    }

    /* Returns T t if successful. Returns null if not successful.*/
    public T insert( T t ) {
        T ret = null;
        int circular_index = findCircularIndexForInsert();
        if ( !isFull() ) {
            logger.debug ( "Inserting " +t);
            if ( circular_index != -1 ) {
                logger.debug("This is a circular queue");
                array_based_circular_queue[circular_index] = t;
                rear = circular_index;
                ++current_size;
                ret = t;
            } else {
                ++rear;
                array_based_circular_queue[rear] = t;
                ++current_size;
                ret = t;
            }
        }
        return ret;
    }

    /* Returns circular index = first lowest index containing a null value*/
    private int findCircularIndexForInsert() {
        int ret = -1;
        for ( int i = 0; i < front; i++ ) {
            if ( array_based_circular_queue[i] == null ) {
                circular_queue = true;
                ret = i;
                break;
            }

        }
        return ret;
    }

    /* Returns circular index = first highest index containing a non null value*/
    private int findCircularIndexForRemove() {
        int ret = -1;
            for (int i = rear; i >= 0; i--) {
                if (array_based_circular_queue[i] != null) {
                    circular_queue = true;
                    ret = i;
                    break;
                }

            }
        return ret;
    }

    private boolean areNonCircularIndicesProcessed() {
        boolean ret = true;
        for ( int i = front; i < rear; i++ ) {
            if ( array_based_circular_queue[i] != null ) {
                ret = false;
                break;
            }
            //break;
        }
        return ret;
    }
    /* Returns T t if successful. Returns null if not successful.*/
    public T remove() {
        T t = null;
        int circular_index = -1;

        if (!isEmpty()) {

            t = array_based_circular_queue[front];
            array_based_circular_queue[front] = null;
             // need some way to check for bounds here.
            if ( circular_queue && areNonCircularIndicesProcessed() ) {
                circular_index = findCircularIndexForRemove();
            }
            if ( circular_index != -1 ){
                front = rear;
                current_size = rear;
            } else {
                ++front;
                --current_size;
            }
        }

        return t;
    }

    private boolean circularQueue() {
        boolean ret = false;
        for ( int i = front; i > rear && i < current_size; i-- ) {
            if ( array_based_circular_queue[i] == null ) {
                ret = true;
            }
        }
        return ret;
    }
    /* Returns element at the front of the queue if queue is not empty, otherwise returns null. */
    public T peek() {
        T t = null;
        if ( !isEmpty() ) {
            t = array_based_circular_queue[front];
        }
        return t;
    }

    private boolean isFull() {
        return current_size == DEFAULT_SIZE ;
    }

    private boolean isEmpty() {
        return current_size == 0;
    }

    public void populate() {
        Random rand = new Random(1);
        T temp;
        for ( int i = 0; i <  (DEFAULT_SIZE ) ; i++ ) {
            temp = (T) Integer.valueOf( rand.nextInt(30) );
            this.insert( temp );
        }
    }

    protected void print() {
        logger.debug( Arrays.toString(array_based_circular_queue));
    }

    protected int getCurrent_size() {
        return current_size;
    }

    private int getDefaultSize() {
        return DEFAULT_SIZE;
    }
}
