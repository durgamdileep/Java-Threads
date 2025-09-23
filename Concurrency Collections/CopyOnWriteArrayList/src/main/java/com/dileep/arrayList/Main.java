package com.dileep.arrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args){

        // Array list is not a thread-safe and it leads to data corruption when multi threads are operating on it
        // we will get an exception java.util.ConcurrentModificationException
        // to over come this issue and to avoid data corruption with thread-safe when we have to use
        // CopyOnWriteArrayList which is designed for concurrency and thread-safe when multiple threads are using the shared resource
        List<Integer> arrayList= new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        Thread writingIntoList= new Thread(
                ()->{
                    try {
                        Thread.sleep(50);
                    for (int i = 4; i <= 8; i++) {
                        System.out.println(Thread.currentThread().getName() + " added an element into list: " + i);
                        arrayList.add(i);
                        Thread.sleep(50);
                    }
                }catch (InterruptedException ex){
                    System.out.println(Thread.currentThread().getName()+" is interrupted..");
                }
                },"Writer-1");

        Thread readingFromList= new Thread(
                ()->{
                    try{
                        Thread.sleep(25);
                        for(Integer i: arrayList){
                            System.out.println(Thread.currentThread().getName()+" is reading the value: "+ i);
                            Thread.sleep(50);
                        }
                    }catch (InterruptedException ex){
                        System.out.println(Thread.currentThread().getName()+ " is interrupted..");
                    }
                },"Reader-1");

        writingIntoList.start();
        readingFromList.start();
        try{
            writingIntoList.join();
            readingFromList.join();
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("Final Arraylist: "+ arrayList);
    }
}
