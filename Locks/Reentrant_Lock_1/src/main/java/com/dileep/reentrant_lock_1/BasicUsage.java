package com.dileep.reentrant_lock_1;

import java.util.concurrent.locks.ReentrantLock;

public class BasicUsage {
    private  final ReentrantLock reentrantLock= new ReentrantLock();

    public void mainHouseKey(int task){
        System.out.println(Thread.currentThread().getName()+" is working for Task: "+task+ " waiting for the main enters key of the house");
        reentrantLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" is working for Task: "+task+ " Entered into the house...");
            bedRoom(task);
        }finally {
            System.out.println(Thread.currentThread().getName()+" is working for Task: "+ task+ " released the Main House (lock) key....");
            reentrantLock.unlock();
        }
    }
    public  void bedRoom(int task){
        System.out.println(Thread.currentThread().getName()+" is working for Task: "+task+ " waiting to acquire the (lock) key of the bedroom");
        reentrantLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" is working for Task: "+task+ " Entered into the Bedroom...");
        }finally {
            System.out.println(Thread.currentThread().getName()+" is working for Task: "+task+ " released the Bedroom lock...");
            reentrantLock.unlock();
        }

    }
}
