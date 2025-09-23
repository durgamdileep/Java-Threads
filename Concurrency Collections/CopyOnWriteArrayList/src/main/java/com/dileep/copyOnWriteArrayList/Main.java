package com.dileep.copyOnWriteArrayList;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
  public  static  void main(String[] args){

      CopyOnWriteArrayList<Integer> copyOnWriteArrayList= new CopyOnWriteArrayList<>();
      copyOnWriteArrayList.add(1);
      copyOnWriteArrayList.add(2);
      copyOnWriteArrayList.add(3);

      Thread writingIntoList= new Thread(
              ()->{
                  try {
                      Thread.sleep(50);
                      for (int i = 4; i <= 8; i++) {
                          System.out.println(Thread.currentThread().getName() + " added an element into list: " + i);
                          copyOnWriteArrayList.add(i);
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
                      for(Integer i: copyOnWriteArrayList){
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
      System.out.println("Final Arraylist: "+ copyOnWriteArrayList);
  }
}
