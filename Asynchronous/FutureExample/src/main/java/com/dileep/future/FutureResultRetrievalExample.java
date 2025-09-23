package com.dileep.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureResultRetrievalExample {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {
           // try{

                return Thread.currentThread().getName()+" is worked to get the result: "+ (10 + 20);
            //}
//            catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName()+" is interrupted..");
//                return Thread.currentThread().getName()+" is interrupted..";
//            }

        });
        future.cancel(true);

            String result = future.get();  // blocks until result is ready
            System.out.println(result);  // Result: 30
            System.out.println("Main Thread is doing some other work...");


        executor.shutdown();

    }
}
//  Explanation :
// submit() starts the task asynchronously.
// future.get() blocks until the task finishes and returns the result.
