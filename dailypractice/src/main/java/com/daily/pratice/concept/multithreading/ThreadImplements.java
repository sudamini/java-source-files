package com.daily.pratice.concept.multithreading;

/**
 * This class creates a thread by using an instance of Runnable interface.
 * 1. Create an instance of Runnable interface.
 * 2. Pass this instance to the constructor of thread class.
 * 3. Call start() method on the thread.
 *
 * Can also be created using Lambda expressions because Runnable interface is a functional interface.
 */
public class ThreadImplements implements Runnable {

    public static void main ( String[] args ) {
        // old way
        ThreadImplements impl = new ThreadImplements();
        Thread thread1 = new Thread(impl);
        thread1.start();
        //lambda way
        Runnable runnable = ()->{System.out.println ("Run Lambda Run" + Thread.currentThread().getName());};
        Thread thread = new Thread(runnable);
        thread.start();

    }
    @Override
    public void run() {
        System.out.println ("Run Old Man Run" +Thread.currentThread().getName() );
    }
}
