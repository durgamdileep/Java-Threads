package com.dileep.Transformation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static  void main(String[] args) throws ExecutionException, InterruptedException {
        LocalDB db= new LocalDB();

        Book newBook= new Book(6,"ABC","CDE","VK","IND");

        //getting the book info
        CompletableFuture<Book>  bookCF= CompletableFuture.supplyAsync(()->{
           return db.getBookById(1);
        });
        System.out.println(bookCF.get());// blocks the main thread until it finishes its task.

        // getting the book result by non-blocking other thread
        // thenApply and thenAccept
        CompletableFuture.supplyAsync(()->{
            return db.getAllBooks();
        }).thenApply(books -> {
            books.add(newBook);
            return  books;
          }).thenAccept(books -> {
               System.out.println(books.get(5));
        }).thenRun(()->{
            System.out.println(Thread.currentThread().getName()+" is finishes it task...");
        });

    }
}
