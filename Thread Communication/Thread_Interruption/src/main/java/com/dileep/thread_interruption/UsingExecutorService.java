package com.dileep.thread_interruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingExecutorService {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<?>[] futures = new Future[15];

        // Step 1: Submit all tasks
        for (int task = 0; task < 15; task++) {
            int taskId = task;
            futures[task] = executorService.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is working for task: " + taskId + ", going to sleep....");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " of task: " + taskId + " has woken up");
                } catch (InterruptedException ex) {
                    System.out.println(Thread.currentThread().getName() + " of task: " + taskId + " was interrupted...");
                }
            });
        }

        // Step 2: Wait a bit before cancelling
        Thread.sleep(2000);
        System.out.println("\n=== Attempting to interrupt all tasks ===\n");

        // Step 3: Cancel all tasks
        for (Future<?> future : futures) {
            if (future != null) {
                future.cancel(true);
            }
        }

        // Step 4: Shutdown executor
        executorService.shutdown();
    }
}
