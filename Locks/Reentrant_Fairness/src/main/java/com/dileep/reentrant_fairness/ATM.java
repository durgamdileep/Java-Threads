package com.dileep.reentrant_fairness;

import java.util.concurrent.locks.ReentrantLock;

public class ATM {
    private  final ReentrantLock reentrantLock= new ReentrantLock(true);
    public void machine(int taskId) throws InterruptedException {
        System.out.println("Task " + taskId + " requesting lock...");
        long beforeLock = System.nanoTime();

        reentrantLock.lock();  // This is when queue order starts
        long afterLock = System.nanoTime();

        try {
            System.out.println("Task " + taskId + " acquired lock (waited " + (afterLock - beforeLock) / 1_000_000 + " ms)");
            Thread.sleep(200);
        } finally {
            reentrantLock.unlock();
            System.out.println("Task " + taskId + " released lock");
        }
    }

}
