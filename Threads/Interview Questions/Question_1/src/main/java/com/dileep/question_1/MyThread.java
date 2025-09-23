package com.dileep.question_1;

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}
