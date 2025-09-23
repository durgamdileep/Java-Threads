package com.dileep.producer_consumer_using_semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        int producerCount = 5;
        int consumerCount = 5;
        ExecutorService executor = Executors.newFixedThreadPool(producerCount + consumerCount);

        // Start producer threads
        for (int i = 0; i < producerCount; i++) {
            executor.execute(() -> {
                for(int task=1;task<=5;task++) {
                    try {
                        pc.doProduce();
                       Thread.sleep(100); // simulate production delay
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        // Start consumer threads
        for (int i = 0; i < consumerCount; i++) {
            executor.execute(() -> {
                for(int task=1;task<=5;task++) {
                    try {
                        pc.doConsume();
                        Thread.sleep(150); // Optional: simulate consumption delay
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        Thread.sleep(5000);
        executor.shutdown();
        // Note: You can optionally add shutdown logic if you want this to terminate
    }
}
