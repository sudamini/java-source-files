package com.practice.datastructures.queues;

import com.practice.datastructures.RootLogger;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class Queue_bkp {
    private static Logger logger;

    static {
        logger = RootLogger.getLogger();
    }

    private static final int DEFAULT_SIZE = 8;
    private int queue_size;
    private static Queue_bkp instance;
    private int[] queue_int_array;
    private int front;
    private int rear;

    private boolean isCircular;


    private Queue_bkp() {
            queue_int_array = new int[DEFAULT_SIZE];
            front = 0;
            rear = (-1);
    }

    static Queue_bkp getInstance() {
        if (instance == null) {
            synchronized (Queue_bkp.class) {
                if (instance == null) {
                    instance = new Queue_bkp();
                }
            }
        }
        return instance;
    }
    /* Creates an empty queue of size = DEFAULT_SIZE
     */
    protected Queue_bkp createNewQueue() {
           instance =  Queue_bkp.getInstance();
           logger.debug( "Created new queue of default size " + instance.default_size() + " and current size " + instance.size() );
           return instance;
    }
    /* Inserts a new integer to queue and returns the new item that was inserted, if queue is not full.
       If the queue is full, it will return (-1). Caller has to handle return value respectively
     */
    protected int insert ( int newItem ) {
        int ret = -1;
        int circularIdx = getCircularIndex();
        if ( !isFull() && circularIdx == (-1)) {
            logger.debug ( "Queue_bkp is not full. Inserting " + newItem );
            ++rear;
            queue_int_array[rear] = newItem;
            ++queue_size;
            logger.debug ( "Queue_bkp parameters: current size =  " + this.size() + " front = " + this.front + " rear " + this.rear + " item at rear =  " + this.queue_int_array[rear] + " item at front = " + this.peek() );
            ret = newItem;
        } else if ( circularIdx != -1 ) {
            logger.debug ( "Queue_bkp is full at rear end.  Inserting  "+newItem+ " at circular index of " +circularIdx );
            queue_int_array[circularIdx] = newItem;
            rear = circularIdx;
            ++queue_size;
            isCircular = true;
            logger.debug ( "Queue_bkp parameters: front index = " + front + " rear index = " + rear );
            logger.debug ( "Item at rear is " + queue_int_array[rear]);
       }
        else {
            System.out.println ("Queue_bkp is full, cannot insert " + newItem );
        }
        return ret;
    }

    protected void populate () {
        Random rand = new Random(1);
        int temp;
        int default_size = this.default_size();
        for ( int i = 0; i <  default_size ; i++ ) {
            temp = rand.nextInt(30);
            this.insert( temp );
        }
    }

    private int getCircularIndex() {
        int ret = -1;
        logger.debug ( "in method getCircularIndex. Value of front = " + front );
        for ( int i = 0; i < front; i++ ) {
            if ( queue_int_array[i] == 0 ) {
                logger.debug ( "Queue_bkp has empty spot at lowest index of " + i );
                ret = i;
            }
            break;
        }
        return ret;
    }
    /* Removes integer from the front of the queue and returns what was removed, if queue is not empty.
       If the queue is empty, it will return (-1). Caller has to handle return value respectively
     */
    protected int remove () {
        int ret = -1;

        if ( !isEmpty() ) {
            logger.debug ( "Queue_bkp is not empty. Removing " + queue_int_array[front] );
            logger.debug ( "Queue_bkp parameters before removing: Front =  " + front + " Current Queue_bkp Size = " + size() + " Rear = " + rear );
            ret = queue_int_array[front];
            queue_int_array[front] = 0;
            ++front;
            // if queue is circular, we want front = rear
            if ( rear < front && queue_size != default_size() && queue_int_array[front] == 0 ) {
                logger.debug("circular queue");
                logger.debug ( "Queue_bkp parameters in circular queue: Front =  " + front + " Current Queue_bkp Size = " + size() + " Rear = " + rear );
                front = rear;
            }
            --queue_size;
            logger.debug ( "Queue_bkp parameters after removing: Front =  " + front + " Current Queue_bkp Size = " + size() + " Rear = " + rear );
        } else {
            logger.debug("Queue_bkp is empty ");
        }
        return ret;
    }
    /* Shows what is at the front of the queue
     */
    protected int peek() {
        int ret = -1;
        if ( !isEmpty() ) {
            ret = queue_int_array[front];
        }
        return ret;
    }

    private boolean isFull() {
        boolean ret = false;
        if ( queue_size == DEFAULT_SIZE ) {
            ret = true;
        }
        return ret;
    }

    private boolean isEmpty() {
        boolean ret = false;
        if ( queue_size == 0) {
            ret = true;
        }
        return ret;
    }

    protected int size() {
        return queue_size;
    }

    protected int default_size() {
        return queue_int_array.length;
    }

    protected void print() {
        logger.debug (Arrays.toString( this.queue_int_array ));
    }

}
