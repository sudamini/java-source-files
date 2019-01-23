package com.daily.pratice.concept.multithreading.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

final class MemberCache {

    private static Map<String,Member> memberCache;
    private static final int THREAD_POOL_SIZE = 5;

    static {
        memberCache = new ConcurrentHashMap<>();
    }
    public static void main(final String[] args){
        populate();
        read();
    }
    private static void populate() {
        write();
    }
    private static void write(){
        Runnable writer = () -> {
            ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
            //synchronized (memberCache) {
                try {
                    writeLock.lock();
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Writer thread " + Thread.currentThread().getName());
                    memberCache.put("" + i, new Member(""+i,888d));
                }
            } finally {
                writeLock.unlock();
            }
        };
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(writer);
        service.shutdown();
    }
    private static void read(){
        Runnable reader = () -> {
            for( int i = 1; i <=10; i++ ) {
                System.out.println("Reader thread " +Thread.currentThread().getName() + ": " +memberCache.get(""+i));
            }
        };

        ExecutorService readService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for( int i = 0; i < THREAD_POOL_SIZE; i++ ) {
            readService.execute(reader);
        }
        readService.shutdown();
    }
}
