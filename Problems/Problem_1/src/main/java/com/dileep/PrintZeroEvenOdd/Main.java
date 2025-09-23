package com.dileep.PrintZeroEvenOdd;

public class Main {
    public static  void main(String[] args){
        ZeroEvenOdd zeroEvenOdd= new ZeroEvenOdd(1);

        Thread zeroThread= new Thread(()-> {
            try {
                zeroEvenOdd.zero();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread evenThread= new Thread(()-> {
            try {
                zeroEvenOdd.even();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread oddThread= new Thread(()-> {
            try {
                zeroEvenOdd.odd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        zeroThread.start();
        evenThread.start();
        oddThread.start();
        try{
            zeroThread.join();
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
