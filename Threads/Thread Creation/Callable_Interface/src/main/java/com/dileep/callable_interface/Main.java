package com.dileep.callable_interface;


import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        //callable interface can be access by using only ExecutorService Frame work
        // creating the fixed thread pool instance by using Executors

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        Callable<String> callable1= new MyCallable("Thread-1");
        Callable<String> callable2 = new MyCallable("Thread-2");
        MyCallable callable= new MyCallable("Thread-");

        try {
            //execute method will not support for callable instance

            // Submit Callable tasks to the executor and get Future objects
            Future<String> future1 = executorService.submit(callable1);
            Future<String> future2 = executorService.submit(callable2);

            // Get results from Future objects by using get method , which will blocks until the task completes
            System.out.println("Result from first task:");
            System.out.println(future1.get()); // Blocks until the task completes

            System.out.println("Result from second task:");
            System.out.println(future2.get()); // Blocks until the task completes

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task execution interrupted: " + e.getMessage());
        }finally {
            // Shutdown the executor
            executorService.shutdown();
        }

    }
}
