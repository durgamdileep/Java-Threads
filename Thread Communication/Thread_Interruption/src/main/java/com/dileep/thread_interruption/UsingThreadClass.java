package com.dileep.thread_interruption;

public class UsingThreadClass {
    public static  void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(()->{
            try{

                System.out.println(Thread.currentThread().getName()+"  is going to sleep....");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+" is woke up");
            }catch (InterruptedException ex){
                System.out.println(Thread.currentThread().getName()+"  is interrupted...");
            }

        },"Thread-1");

        t1.start();

        Thread.sleep(1000);
        t1.interrupt();

    }
}
