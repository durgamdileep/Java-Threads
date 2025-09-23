package com.dileep.reentrant_fairness;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main{
    public  static  void main(String[] args) throws InterruptedException {
        ATM atm= new ATM();
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        //
        for (int i = 1; i <= 20; i++) {
            int taskId = i;
            executorService.execute(() -> {
                try {
                    atm.machine(taskId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        }
    }


