package com.dileep.question_7;

import java.util.concurrent.Callable;

public class MyRunnable implements Runnable{
    private final Callable<String> myCallable;
    MyRunnable(Callable<String> myCallable){
        this.myCallable=myCallable;
    }
    @Override
    public void run() {
        try {
            System.out.println("Printing the Result in MyRunnable : "+"\n"+myCallable.call());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
