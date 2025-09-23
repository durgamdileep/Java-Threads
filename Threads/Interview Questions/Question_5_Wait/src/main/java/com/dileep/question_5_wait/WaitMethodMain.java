package com.dileep.question_5_wait;

public class WaitMethodMain {
    public static void main(String[] args){
        SharedResource sharedResource= new SharedResource();
        Thread t1= new Thread(()->sharedResource.waitExample(),
                "Thread-1");
        Thread t2= new Thread(()->{
            try{
                Thread.sleep(2000); // Ensure Thread-1 goes to wait state
                sharedResource.notifyMethod();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        },"Thread-2");
       t1.start();
       t2.start();
    }
}
