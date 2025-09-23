package com.dileep.reentrant_lock_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public  static  void main(String[] args){
        BasicUsage basicUsage= new BasicUsage();
        ExecutorService executorService= Executors.newFixedThreadPool(5);

        for(int task=0;task<5;task++){
            int taskId = task;
            executorService.execute(()->basicUsage.mainHouseKey(taskId));
        }
        executorService.shutdown();
        try{
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException ex){
            System.out.println("all task are not finished");
        }
    }
}
