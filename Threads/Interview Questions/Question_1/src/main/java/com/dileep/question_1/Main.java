package com.dileep.question_1;

public class Main {
    public static  void  main(String[] args){
        MyThread runnable= new MyThread();
        Thread t1= new Thread(runnable,"Thread-1");
        // Starts a new thread and call the run method
        t1.start();

        Thread t2= new Thread(runnable);
        t2.run();// use the main thread , it will not create any new thread , use the current thread
    }
}
