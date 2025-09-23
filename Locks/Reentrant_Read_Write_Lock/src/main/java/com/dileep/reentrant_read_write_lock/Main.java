package com.dileep.reentrant_read_write_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public  static  void main(String[] args) throws  InterruptedException{
        Reentrant_Read_Write read_write= new Reentrant_Read_Write();

        ExecutorService executorService= Executors.newFixedThreadPool(10);

        executorService.execute(()-> {
            try {
                read_write.readData("Reader-1");
            } catch (InterruptedException e) {
                System.out.println("Reader-1 is Interrupted");
            }
        });

        executorService.execute(()->{
            try{
                read_write.readData("Reader-2");
            }catch (InterruptedException ex){
                System.out.println("Reader-2 is Interrupted");
            }
        });

        executorService.execute(()->{
            try{
                read_write.readData("Reader-3");
            }catch (InterruptedException ex){
                System.out.println("Reader-3 is Interrupted");
            }
        });

        executorService.execute(()->{
            try{
                read_write.writeData("Writer-1",138);
            }catch (InterruptedException ex){
                System.out.println("Writer-1 is Interrupted");
            }
        });

        executorService.execute(()->{
            try{
                read_write.readData("Reader-4");
            }catch (InterruptedException ex){
                System.out.println("Reader-4 is Interrupted");
            }
        });

        executorService.execute(()->{
            try{
                read_write.writeData("Writer-2",145);
            }catch (InterruptedException ex){
                System.out.println("Writer-2 is Interrupted");
            }
        });



        executorService.execute(()->{
            try{
                read_write.readData("Reader-5");
            }catch (InterruptedException ex){
                System.out.println("Reader-5 is Interrupted");
            }
        });

        Thread.sleep(5000);
        executorService.shutdown();



    }
}
