package com.daily.pratice.concept.multithreading.ExecutorExceptionHandling;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

class TaskExecution {

    public static void main (final String[] args ) {
        new TaskExecution().process();
    }
    // This is a handler for unsafe task executions that satisfy following requirements.
    //1. Execute Runnable code
    //2. Dont use try, catch, finally
    //3. Set UncaughtExceptionHandler
    class UnsafeTaskExecutionHandler extends TaskExecution implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println( "Thread terminated with exception " + e.getMessage() );
        }
    }

    /**
     * If a task throws uncheckedException, allow the thread to die but notify the framework that the thread has died.
     */
    private void process(){

        // This executes safe task.
        Callable<Integer> safeTask = ()-> {
            Thread.sleep(1000);
            return 80000/23;
        };
        // This executes unsafe task, it will throw RuntimeException. This is logging this exception and exiting.
        Callable<Integer> unsafeTask = ()-> {
            Throwable thrownException = null;
            Integer result = 0;
            try {
                Thread.sleep(1000);
                result = 8000 / 0;
            } catch (Throwable t) {
                System.out.println("Thread " + Thread.currentThread().getName() + " has died ");
                thrownException = new RuntimeException();
            } finally {
                threadExited(this,thrownException);
            }
            return result;
        };

        // This uses unCaughtExceptionHandler to catch any uncaught exception.
        Runnable unsafeTaskUncaughtException = ()-> {
            Thread.currentThread().setUncaughtExceptionHandler(new UnsafeTaskExecutionHandler());
            int result = 8000 / 0;
        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            List<Future<Integer>> results = new LinkedList<>();
            Future<Integer> safeRes, unsafeRes;
            for (int i = 0; i < 2; i++) {
                safeRes = service.submit(safeTask);
                System.out.println("Safe task execution result " + safeRes.get());
                results.add(safeRes);
                unsafeRes = service.submit(unsafeTask);
                System.out.println("unsafe task execution result " + unsafeRes.get());
                results.add(unsafeRes);
                service.execute(unsafeTaskUncaughtException);
            }
        } catch( InterruptedException | ExecutionException e ){
            System.out.println("Caught " + e);
        } finally {
            service.shutdown();
        }
    }
    private static void threadExited(TaskExecution task, Throwable t){
        System.out.println("Task exited with " + t.getMessage());
    }
}
