package com.daily.pratice.concept.multithreading;

/*
Thread A has access to object A and will not release monitor until it gets access to object B
Thread B has access to object B and will not release monitor until it gets access to object A
 */
class Deadlock  {
    private final Object lock1;
    private final Object lock2;

    private Deadlock() {
        lock1 = new Object();
        lock2 = new Object();
    }

    public static void main ( String[] args ) {
        Deadlock deadlock = new Deadlock();
        //create Runnable objects
        WorkerThread1 workerThread1 = deadlock.new WorkerThread1();
        WorkerThread2 workerThread2 = deadlock.new WorkerThread2();

        //pass Runnable objects to Thread's constructor and start both threads.
        Thread worker1 = new Thread( workerThread1);
        Thread worker2 = new Thread( workerThread2);
        worker1.start();
        worker2.start();

    }
    private void doWork( Object lock1, Object lock2 ) {
        for ( int i = 0; i < 100; i++ ) {
            System.out.println ("I am doing work");
        }
    }

    private class WorkerThread1 implements Runnable {

        @Override
        public void run() {
            synchronized ( lock1 ) {
                System.out.println(Thread.currentThread().getName() + " has lock1");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " got both");
                    doWork(lock1, lock2);
                }
            }
        }
    }

    private class WorkerThread2 implements Runnable {

        @Override
        public void run() {
            synchronized ( lock2 ) {
                System.out.println ( Thread.currentThread().getName() + " has lock2");
                synchronized (lock1){
                    System.out.println ( Thread.currentThread().getName() + " got both!");
                    doWork( lock1, lock2 );
                }
            }
        }
    }
}
