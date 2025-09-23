package com.dileep.reentrant_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public  static void main(String[] args){
        Lock myLock= new Lock();
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for(int task =1;task<=150000;task++){
            executorService.execute(()->myLock.increment());
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Some tasks didn't finish in time.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + myLock.getCounter());
    }
}
