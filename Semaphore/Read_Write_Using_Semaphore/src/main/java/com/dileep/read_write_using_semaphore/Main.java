package com.dileep.read_write_using_semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReadWrite rw= new ReadWrite();
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        executorService.execute(()->{
            try {
                rw.readMethod("Reader-1");
            } catch (InterruptedException e) {
                System.out.println("Reader-1 is interrupted...");
            }
        });
        executorService.execute(()->{
            try{
                rw.readMethod("Reader-2");
            }catch (InterruptedException ex){
                System.out.println("Reader-2 is interrupted...");
            }
        });
        executorService.execute(()->{
            try{
                rw.writeMethod("Writer-1",123);
            }catch (InterruptedException ex){
                System.out.println("Writer-1 is interrupted...");
            }
        });
        executorService.execute(()->{
            try{
                rw.readMethod("Reader-3");
            }catch (InterruptedException ex){
                System.out.println("Reader-3 is interrupted...");
            }
        });
        executorService.execute(()->{
            try{
                rw.writeMethod("Writer-2",123);
            }catch (InterruptedException ex){
                System.out.println("Writer-2 is interrupted...");
            }
        });
        Thread.sleep(1000);
        executorService.shutdown();

    }
}
