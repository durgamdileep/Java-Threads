package com.dileep.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CancellationExample {
    public  static  void main(String[] args) throws  InterruptedException{
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<?> future=executorService.submit(()->{
            while(true){
                System.out.println(Thread.currentThread().getName()+" is running..");
                if(Thread.currentThread().isInterrupted()) break;//  Exit immediately stop task here
            }
        });
        Thread.sleep(200);
        // cancel  method is tries to interrupt if the task is running.
        // but we have to implicit the write logic of interrupted logic in the thread.
        boolean cancelled = future.cancel(true); // interrupt the thread
        System.out.println("Cancelled: " + cancelled);

        executorService.shutdown();
    }
}
