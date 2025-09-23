package com.dileep.producer_consumer;

public class Main {
    public static  void  main(String[] args){
        ProducerConsumer producerConsumer= new ProducerConsumer();

        Thread producerThread= new Thread(
                ()->{
                    try {
                        producerConsumer.produce();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },"Producer-Thread"
        );
        Thread consumerThread = new Thread(
                ()->{
                    try {
                        producerConsumer.consume();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },"Consumer-Thread"
        );

        producerThread.start();
        consumerThread.start();

    }
}
