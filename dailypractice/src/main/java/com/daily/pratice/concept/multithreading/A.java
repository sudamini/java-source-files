package com.daily.pratice.concept.multithreading;

/**
 * This class can create a possible deadlock.
 * One thread can call a(), gain access to key1 and at the same time, another thread can call b() and gain access to key2.
 * a() calls b() and b() calls a() but a() needs key2 to call b() and b() needs key1 to call a() so both threads can be deadlocked.
 */
class A {

    private final Object key1 = new Object();
    private final Object key2 = new Object();

    void a(){
       synchronized (key1){
            System.out.println("I am in a() " +Thread.currentThread().getName());
            b();
       }
    }
    void b(){
        synchronized (key2){
            System.out.println("I am in b() " +Thread.currentThread().getName());
            a();
        }
    }
    /*void c(){
        synchronized (key1){
            System.out.println("I am in a() " +Thread.currentThread().getName());
        }
    } */

}
