package com.daily.pratice.concept.blockingqueue;

import java.util.LinkedList;

/**
 * LinkedList based blocking queue. FIFO. Consumer thread will consume from head. Producer thread will produce at tail.
 * Producer will block if blocking queue is at full capacity.
 * Consumer will block if blocking queue is empty.
 * Synchronization - The whole linkedlist does not need to be synchronized. both threads should be able to operate
 * simultaneously.
 */

final class BlockingQueue {
    private static final LinkedList<Integer> queue = new LinkedList<>();
    private static final int CAPACITY = 10;

    public static void main(final String[] args) {
        enqueue();
        dequeue();
    }

    private static void enqueue() {
        Runnable enqueue = () -> {
            int val = 0;
            try {
                while (true) {
                    synchronized (queue) {
                        while (queue.size() == CAPACITY) {
                            System.out.println("Enqueue waiting.");
                            queue.wait();
                            Thread.sleep(1000);
                        }
                        queue.notify();
                    } // end synchronized
                    System.out.println("Added:" + val);
                    queue.addLast(val++);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        /*This will start only one thread which will add to back of the queue  */
        Thread add = new Thread(enqueue);
        add.start();
    }

    private static void dequeue() {
        Runnable dequeue = () -> {
            try {
                while (true) {
                    int val = 0;
                    synchronized (queue) {
                        while (queue.size() == 0) {
                            System.out.println("Dequeue waiting.");
                            queue.wait();
                            Thread.sleep(1000);
                        } // end while
                        queue.notify();
                    } // end synchronized
                    if (queue.peekFirst() != null) {
                        val = queue.removeFirst();
                        System.out.println("Removed:" + val);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        /* This is for only one thread which will continue to remove from front of the queue. */
        Thread remove = new Thread(dequeue);
        remove.start();
    }


}
