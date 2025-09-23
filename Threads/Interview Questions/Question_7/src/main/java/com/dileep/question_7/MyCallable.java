package com.dileep.question_7;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Here is the result from MyCallable";
    }
}
