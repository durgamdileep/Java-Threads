package com.dileep.runnable_interface;

public class Main {
    public static  void main(String[] args){
        MyRunnable runnable= new MyRunnable(); // Create only one runnable instance

        Thread t1= new Thread(runnable,"Thread-1"); // Create thread with runnable
        Thread t2= new Thread(runnable,"Thread-2"); // Create another thread with same runnable

        t1.start(); // Start the first thread
        t2.start(); // Start the second thread

        // Create a thread with new runnable
        Thread t3= new Thread( ()->{
             for(int i=0;i<3;i++){
                 System.out.println("Thread Name:" + Thread.currentThread().getName()+ " is running : "+i);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     System.out.println("Thread Interrupted");
                 }

             }
        },"Thread 3"
        );
        t3.start();
    }
}
