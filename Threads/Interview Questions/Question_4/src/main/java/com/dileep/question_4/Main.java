package com.dileep.question_4;

public class Main {
    public static void main(String[] args){

        Thread t1= new Thread(()->{
                throw new RuntimeException("Exception in thread "+ Thread.currentThread().getName());
        },"Thread-1");
        t1.start();
        // t1.run();  //this will throw exception in main thread because run method will execute on current thread

        System.out.println(Thread.currentThread().getName()+" is still running");
    }
}
