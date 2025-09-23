package com.dileep.producer_consumer_using_semaphore;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {
    private final AtomicInteger number = new AtomicInteger(1);
    private final int QUEUE_SIZE = 5;
    private final Semaphore emptySlots = new Semaphore(QUEUE_SIZE);
    private final Semaphore filledSlots = new Semaphore(0);
    //in place of Concurrent Linked Queue if i use
    //Queue<Integer> q= new LinkedList<>() then LinkedList is not thread-safe, and you're accessing it concurrently from multiple threads without synchronization.
    // Even though semaphores manage the slot counts, they do not protect the actual queue operations, leading to race conditions and issues like:
    //    The same value being consumed twice
    //    Nulls being returned
    //    Values being lost or overwritten



    // that is the reason  i choose ConcurrentLinkedQueue is thread-safe when multiple threads access the queue operations.
    private final ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    public void doProduce() throws InterruptedException {
        emptySlots.acquire();
        int value = number.getAndIncrement();
        queue.offer(value);
        System.out.println(Thread.currentThread().getName()+" Value stored in queue: " + value);
        filledSlots.release();
    }

    public void doConsume() throws InterruptedException {
        filledSlots.acquire();
        Integer consumedValue = queue.poll();
        if (consumedValue != null) {
            System.out.println(Thread.currentThread().getName()+" Consumed value for the queue: " + consumedValue);
        }
        emptySlots.release();
    }
}
