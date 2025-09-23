package com.dileep.future;

import java.util.concurrent.*;

public class CancelExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<?> future = executor.submit(() -> {
            // Task that ignores interruption
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Running iteration " + i);
                    Thread.sleep(1000); // This can throw InterruptedException, but we ignore it here
                } catch (InterruptedException e) {
                    // if you ignore the Interruption then it wouldn't cancel the thread.
                    // Ignoring interruption here, so task keeps running

                    // System.out.println(Thread.currentThread().getName()+"  is interrupted..");
                    // Restore interrupt flag and handle later
                    //Thread.currentThread().interrupt();
                }
            }
            System.out.println("Task finished naturally.");
        });

        Thread.sleep(3000); // Let the task run for 3 seconds

        boolean canceled = future.cancel(true); // Attempt to cancel with interruption
        System.out.println("State of Thread: "+ future.state()+" Cancel called, result: " + canceled);

        // Wait a bit to see if task stops
        Thread.sleep(5000);

        executor.shutdown();
    }
}

