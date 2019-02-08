package com.daily.pratice.concept.multithreading.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class ProducerConsumerWithLocks {
    List<Integer> buffer = new ArrayList<>();
    Lock lock = new ReentrantLock();
    Condition isEmpty = lock.newCondition();
    Condition isFull = lock.newCondition();

    public static void main( final String[] args ) {
        ProducerConsumerWithLocks pcl = new ProducerConsumerWithLocks();
        pcl.process();
    }
    private boolean isFull(){
        return buffer.size() == 50;
    }
    private void process(){

        List<Producer> producers = new ArrayList<>();
        for( int i = 0; i < 4; i++ ){
            producers.add(new Producer());
        }
        List<Consumer> consumers = new ArrayList<>();
        for( int i = 0; i < 4; i++ ){
            consumers.add(new Consumer());
        }
        List<Callable<String>> producersAndConsumers = new ArrayList<>();
        producersAndConsumers.addAll(producers);
        producersAndConsumers.addAll(consumers);

        ExecutorService service = Executors.newFixedThreadPool(8);
        try {
            List<Future<String>> futures = service.invokeAll(producersAndConsumers);
            futures.forEach(
                    future -> {
                        try {
                            System.out.println(future.get());
                        } catch (InterruptedException | ExecutionException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                    });
        } catch(Exception e ){
            e.printStackTrace();
        } finally{
            service.shutdown();
            System.out.println("Service shut down" );
        }
    }

    private class Producer implements Callable<String> {

        @Override
        public String call() throws Exception {
            int count = 0;
            try {
                lock.lock();
                while ( count <= 50 ) {
                    while (buffer.size() == 50 ) {
                        //wait
                        isFull.await(10, TimeUnit.MILLISECONDS);
                    }
                    buffer.add(1);
                    ++count;
                    isEmpty.signal();
                }
            } finally {
                lock.unlock();
            }
            return "Produced " +count;
        }
    }
    private class Consumer implements Callable<String> {
        @Override
        public String call() throws Exception {
            int count = 0;
            try {
                lock.lock();
                while ( count <= 50 ) {
                    while (buffer.isEmpty()) {
                        isEmpty.await(10, TimeUnit.MILLISECONDS);
                    }
                    buffer.remove(buffer.size()-1);
                    ++count;
                    isFull.signal();
                }
            } finally {
                lock.unlock();
            }
            return "Consumed " + count ;
        }
    }
}
