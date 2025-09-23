package com.dileep.callable_interface;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private String name;
    MyCallable(String name){
        this.name=name;
    }
    @Override
    public String call() throws Exception {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append("Callable ").append(Thread.currentThread().getName())
                    .append(" is running: ").append(i).append("\n");
            Thread.sleep(500); // Pause execution for 500 milliseconds
        }
        return result.toString(); // Return the result as a String
    }
}
