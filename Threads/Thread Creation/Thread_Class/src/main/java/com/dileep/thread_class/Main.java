package com.dileep.thread_class;

public class Main {
    public static  void main(String[] args){// main thread
        MyThread t1= new MyThread();
        t1.start();// start the first thread

        MyThread t2= new MyThread();
        t2.start();// start the second thread
    }
}
