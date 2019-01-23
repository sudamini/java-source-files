package com.daily.pratice.concept.multithreading;

/**
 * Creates a situation of deadlock by calling methods from class A.
 * Creates two Runnable instances and two threads. Each thread waits on another thread to finish executing.
 * Main thread calls join() on both threads and waits for them to finish executing.
 */
class RunA {
    public static void main ( String[] args ) {
        try {
            A a = new A();
            Runnable runnable1 = () -> {
                a.a();
            };
            Runnable runnable2 = () -> {
                a.b();
            };
            Thread thread1 = new Thread(runnable1);
            Thread thread2 = new Thread(runnable2);
            thread1.start();
            thread2.start();
            //thread1.join();
            //thread2.join();
        } catch( Exception e){
            e.printStackTrace();
        }
    }
}
