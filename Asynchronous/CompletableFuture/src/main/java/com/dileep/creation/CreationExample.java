package com.dileep.creation;

import java.util.concurrent.*;

public class CreationExample {
    public static  void main(String[] args) throws ExecutionException, InterruptedException {

       // Completable Future by default uses ForkJoinPool which uses daemon threads, these thread will exit immediately after the main thread finishes its task.

        // supplyAsync ->  asynchronously execute a task that returns a result.
        // supplyAsync method will accepts two parameter one is supplier functional interface and
        // other parameter as executor when you want to manage your own thread pool by using ExecutorService Framework
        CompletableFuture<?> cf= CompletableFuture.supplyAsync(()->{
           return 10;
        });

        // runAsync -> asynchronous code that does NOT return a result
        // runAsync method accepts Runnable and Executors as its argument values;
        CompletableFuture<Void> cf2= CompletableFuture.runAsync(()->{
           System.out.println("runAsync() method will accept only the Runnable and Executor...");
        });

        // get() will blocks main thread until the future object or task is completes.
        System.out.println(cf.get());
    }
}
