package com.dileep.reentrant_read_write_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reentrant_Read_Write {
    private  final ReentrantReadWriteLock readWriteLock= new ReentrantReadWriteLock();
    private int data=0;

    // rules:
    // When  readlock is locked  to a thread then any other write lock will not be assign to another thread.
    // but multiple threads can access the readlock at the same time

    // When  writelock is locked to a thread , no other read or write lock will not be assigned.




    // Write operation: exclusively updates the shared data value
    public void writeData(String taskName, int newValue) throws InterruptedException {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(taskName + " (write): Acquired write lock.");
            Thread.sleep(5000);
            data = data+newValue;
            System.out.println(taskName + " (write): Updated data to " + data);
        } finally {
            System.out.println(taskName + " (write): Released write lock.");
            readWriteLock.writeLock().unlock();
        }
    }

    // Read operation: reads the shared logValue.
    public void readData(String taskName) throws InterruptedException {
        readWriteLock.readLock().lock();
        try {
            System.out.println(taskName + " (read): Acquired read lock. Reading data: " + data);
            Thread.sleep(5000);
            System.out.println(taskName + " (read): Finished reading.");
        } finally {
            System.out.println(taskName + " (read): Released read lock.");
            readWriteLock.readLock().unlock();
        }

    }

}
