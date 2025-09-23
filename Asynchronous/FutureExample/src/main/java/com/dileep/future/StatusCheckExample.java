package com.dileep.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StatusCheckExample {
    public static  void main(String[] args){

        ExecutorService executorService= Executors.newSingleThreadExecutor();

       Future<Integer> future= executorService.submit(()->{
            return 20;
        });
        // ...some time later
        // isDone method is used to check the status of the thread
        if (future.isDone()) {
            System.out.println("Task completed!"); // Prints -> Task completed!
        } else {
            System.out.println("Still working..."); // Prints -> Still working...
        }
        executorService.shutdown();
    }
}
