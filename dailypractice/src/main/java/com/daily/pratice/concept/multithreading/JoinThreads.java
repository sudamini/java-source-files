package com.daily.pratice.concept.multithreading;
    /*T1 T2 and T3. You want T2 to start after T1 is finished and T3 to start after T2 is finished.
    Call T1.join() from T2 so that T2 will not start until T1 is finished.
    Call T2.join() from T3 so that T3 will not start until T2 is finished.
    IF TWO THREADS CALL A join() method on each other, then they cause deadlock.
     */
class JoinThreads {

    private static Thread1 thread1;
    private static Thread2 thread2;
    private static Thread3 thread3;

    public static void main (String[] args ) {

        thread1 = new Thread1("THREAD1");
        thread2 = new Thread2("THREAD2");
        thread3 = new Thread3("THREAD3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

   private static class Thread1 extends Thread {
        Thread1( String name ) {
            super(name);
        }
       public void run() {
           try {
               System.out.println("Running " + Thread.currentThread().getName());
               //thread2.join();
               Thread.sleep(3);
               System.out.println("Finished " + Thread.currentThread().getName());
           } catch ( Exception e ){
               e.printStackTrace();
           }
       }
   }
   private static class Thread2 extends Thread {
       Thread2( String name ) {
           super(name);
       }
       public void run() {
           try {
               System.out.println("Running " + Thread.currentThread().getName());
               thread1.join(); // calling join() from thread2 on thread1 means thread2 will wait on thread1 to finish execution.
               Thread.sleep(3);
               System.out.println("Finished " + Thread.currentThread().getName());
           } catch ( Exception e ){
               e.printStackTrace();
           }

       }
   }
   private static class Thread3 extends Thread {
       Thread3( String name ) {
           super(name);
       }
       public void run() {
           try {
               System.out.println("Running " + Thread.currentThread().getName());
               thread2.join(); // calling join() from thread3 on thread2 means thread3 will wait on thread2 to finish execution.
               Thread.sleep(3);
               System.out.println("Finished " + Thread.currentThread().getName());
           } catch ( Exception e ){
               e.printStackTrace();
           }
       }
   }

}
