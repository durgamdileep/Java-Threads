package com.dileep.runnable_interface;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable " + Thread.currentThread().getName() + " is running: " + i);
            try {
                Thread.sleep(500); // Pause execution for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
