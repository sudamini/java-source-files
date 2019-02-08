package com.daily.pratice.concept.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Example_Future {

    public static void main(String[] args) throws Exception {
        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return Thread.currentThread().getName();
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
            List<Future<String>> futures = new ArrayList<>();

            for( int i = 0; i < 100; i++ ) {
                Future<String> future = executor.submit(callable);
                System.out.println(future.get());
                futures.add(future);
            }
        }  finally {
            executor.shutdown();
        }

    }
}
