package com.dileep.reentrant_try_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
    public  static  void main(String[] args){

        ATM atm= new ATM();
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        String[] names = new String[2]; // Prefer this form
        names[0] = "virat";
        names[1] = "abd";
        for(String name:names)
        {
            executorService.execute(()-> {
                try {
                    atm.machine1(name);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        try{
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException ex){
            System.out.println("all task are not finished");
        }


    }
}
