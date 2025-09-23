package com.dileep.reentrant_try_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {
    private final ReentrantLock reentrantLock= new ReentrantLock();

    public void machine1(String userName) throws InterruptedException {
        String  methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(userName+" want to acquire the lock of "+methodName+ " immediately...");
        if(reentrantLock.tryLock()){
            System.out.println(userName+" got the lock and using the "+ methodName);
            try{
                System.out.println(userName+" withdrawing the money from "+methodName+" ..");
                Thread.sleep(3000);
            }finally {
                System.out.println(userName+" releasing the lock of "+ methodName);
                reentrantLock.unlock();
            }
        }else{
            System.out.println("Lock/"+methodName+" is busy, "+userName+" going for other machine/leaving the queue line");
            machine2(userName);
        }
    }
    public void machine2(String userName) throws InterruptedException {
        String  methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(userName+" want to wait for 2 seconds to acquire the lock "+methodName+" ...");
        if(reentrantLock.tryLock(2, TimeUnit.SECONDS)){
            System.out.println(userName+" got the lock and using the "+ methodName);
            try{
                System.out.println(userName+" withdraw the money from "+methodName+" ..");
                Thread.sleep(3000);
            }finally {
                System.out.println(userName+" releasing the lock of "+ methodName);
                reentrantLock.unlock();
            }
        }else{
            System.out.println(userName+" waited for 2 seconds still"+"Lock/"+methodName+" is busy, "+userName+" going for other machine/leaving the queue line");
        }

    }
}
