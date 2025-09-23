package com.dileep.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private final Object lock= new Object();
    private final Queue<Integer> queue= new LinkedList<>();
    private final int QUEUE_SIZE=5;
    private  int value=0;

    public void produce() throws InterruptedException {
        while(true){
          synchronized (lock){
              while(queue.size()== QUEUE_SIZE){
                  System.out.println("Queue is full....");
                  lock.wait();
              }
              System.out.println(Thread.currentThread().getName()+" added the value into to queue and the added value : "+ value);
              queue.add(value++);

              lock.notifyAll();
          }
          Thread.sleep(1000);
        }
    }
    public  void consume() throws InterruptedException {
        while(true){
            synchronized (lock) {
                while(queue.isEmpty()){
                    System.out.println("Queue is empty....");
                    lock.wait();
                }
                int consumedValue= queue.poll();
                System.out.println(Thread.currentThread().getName()+" is consumed the data from Queue and the value is: "+consumedValue);
                lock.notifyAll();
            }
            Thread.sleep(1500);
        }
    }
}
