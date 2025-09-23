package com.dileep.question_7;

import java.util.concurrent.Callable;

public class CallableUsingFromRunnable {
    public  static  void main(String[] args){
        Callable<String> myCallable= new MyCallable();
        MyRunnable myRunnable= new MyRunnable(myCallable);
        Thread t1=new Thread(myRunnable);
        t1.start();
    }
}
