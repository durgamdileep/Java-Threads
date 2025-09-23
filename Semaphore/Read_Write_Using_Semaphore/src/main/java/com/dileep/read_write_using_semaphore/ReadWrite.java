package com.dileep.read_write_using_semaphore;

import java.util.concurrent.Semaphore;

public class ReadWrite {
    private final Semaphore read = new Semaphore(1);
    private final Semaphore write = new Semaphore(1);
    int readCount = 0;
    private int number = 10;

    public void readMethod(String name) throws InterruptedException {
        readLock();
        System.out.println(name+" is reading the data: "+ number);
        System.out.println(name + " finished reading.");
        readUnLock();
    }
    public void readLock() throws InterruptedException{
        read.acquire();
        readCount++;
        if (readCount == 1)
            write.acquire(); // blocking the writer by first reader
        read.release();
    }


    public void readUnLock() throws  InterruptedException{
        read.acquire();
        readCount--;
        if(readCount==0){
            write.release();// releasing the writer by last reader
        }
        read.release();
    }
    public void writeMethod(String name, int value) throws InterruptedException {
        write.acquire();
        number = number + value;
        System.out.println(name + " updated the data: " + number);
        write.release();
    }
}
