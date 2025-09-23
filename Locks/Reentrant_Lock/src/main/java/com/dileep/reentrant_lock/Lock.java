package com.dileep.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    private final ReentrantLock reentrantLock= new ReentrantLock();
    private  int counter=0;
    public void increment(){
        reentrantLock.lock();
        counter++;
        reentrantLock.unlock();
    }
    public  int getCounter(){
        return counter;
    }

}
