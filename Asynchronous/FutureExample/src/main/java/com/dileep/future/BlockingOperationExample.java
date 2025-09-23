package com.dileep.future;

import java.util.concurrent.*;

public class BlockingOperationExample {
    public static  void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Future<String> future= executorService.submit( ()->{
            Thread.sleep(3000);
            return "after delay Task Completed";
        });

        System.out.println("Waiting for result...");
        // this line will execute after the future get the value into it,
        String value = future.get(); // blocks for ~3 seconds
        System.out.println(value);
        executorService.shutdown();

    }
}
