package com.dileep.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static  void  main(String[] args){
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        // completableFuture uses ForkJoinPool by default which uses daemon threads.
        // Daemon threads do not keep the JVM alive once the main thread is done.
        // so, mostly use the custom Thread pool.
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(()->{
          try{
              System.out.println(Thread.currentThread().getName()+" is running..");
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              System.out.println(Thread.currentThread().getName()+"  is interrupted...");
          }
          return "after delay task is ";
       },executorService).thenAccept(result->{
           System.out.println(result+" completed...");
      }).thenRun(()->{
          System.out.println("Async Task is Completed, exiting...");
      });
      // join() , get() will block the main  thread
      // CompletableFuture.allOf() even if you want use allOf() to wait for all the thread to complete , here also you need to use join() which means blocking the main thread.

      // simple approach we can use Thread.sleep() method
      // approach 2 use thenRun() method ,this method will run after async is completed without blocking main thread.

        System.out.println("Main thread is free to do other tasks while waiting...");
        executorService.shutdown();
    }
}

