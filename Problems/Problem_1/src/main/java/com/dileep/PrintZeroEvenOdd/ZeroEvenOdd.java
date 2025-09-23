package com.dileep.PrintZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ZeroEvenOdd {
    private  int n;
    public  ZeroEvenOdd(int n){
        this.n=n;
    }
    private  final AtomicInteger number= new AtomicInteger(1);
    private boolean odd= true;
    private  final Semaphore zeroSemaPhore= new Semaphore(1);
    private  final  Semaphore evenSemaPhore= new Semaphore(0);
    private final Semaphore oddSemaPhore= new Semaphore(0);

    public  void zero() throws InterruptedException {
        for(int i=0;i<n;i++) {
            int v=0;
            zeroSemaPhore.acquire();
            System.out.print(v);
            if (odd) {
                oddSemaPhore.release();
            } else {
                evenSemaPhore.release();
            }
            odd = !odd;
        }
    }
    public  void even() throws  InterruptedException{
        for(int i=1;i<=n/2;i++) {
            evenSemaPhore.acquire();
            System.out.print(number.getAndIncrement());
            zeroSemaPhore.release();
        }
    }
    public  void odd() throws InterruptedException {
        for(int i=1;i<=(n-(n/2));i++) {
            oddSemaPhore.acquire();
            System.out.print(number.getAndIncrement());
            zeroSemaPhore.release();
        }
    }
}
