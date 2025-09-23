package com.dileep.question_5_wait;

public class SharedResource {

    synchronized  void waitExample(){
        System.out.println(Thread.currentThread().getName() + " is waiting...");
        try {
            wait(); // Releases the lock and waits
            // which means this will allow other thread to access the method during its waiting period.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " resumed after notify.");
    }

    synchronized  void notifyMethod(){
        System.out.println(Thread.currentThread().getName() +" is Notifying a waiting thread...");
        notify(); // Wakes up one waiting thread
    }
}
