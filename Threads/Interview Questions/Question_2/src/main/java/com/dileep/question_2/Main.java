package com.dileep.question_2;

public class Main {
    public  static  void main(String[] args){

        Thread t1= new Thread(()->{
            System.out.println("Thread Name:"+ Thread.currentThread().getName());
        },"Thread -1");

        t1.start(); // Works fine

        t1.start(); // Throws IllegalThreadStateException
    }
}
