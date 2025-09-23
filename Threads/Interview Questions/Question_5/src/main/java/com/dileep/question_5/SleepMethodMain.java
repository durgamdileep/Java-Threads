package com.dileep.question_5;

public class SleepMethodMain {
    public  static  void main(String[] args){
        System.out.println(Thread.currentThread().getName()+ " is going to sleep");
        try{
            Thread.sleep(3000);// sleep for 3 seconds
            // it will not release the lock ,that means it will not allow other thread to work while it is sleeping
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread woke up after sleeping.");
    }
}
