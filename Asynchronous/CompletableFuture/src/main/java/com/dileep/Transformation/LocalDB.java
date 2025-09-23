package com.dileep.Transformation;

import java.util.ArrayList;
import java.util.List;

public class LocalDB {

    private List<Book> booksList;

    public LocalDB() {
        booksList = new ArrayList<>();

        // Sample data
        booksList.add(new Book(1, "The Alchemist", "Fiction", "Paulo Coelho", "HarperCollins"));
        booksList.add(new Book(2, "Clean Code", "Programming", "Robert C. Martin", "Prentice Hall"));
        booksList.add(new Book(3, "1984", "Dystopian", "George Orwell", "Secker & Warburg"));
        booksList.add(new Book(4, "The Pragmatic Programmer", "Programming", "Andy Hunt", "Addison-Wesley"));
        booksList.add(new Book(5, "Sapiens", "History", "Yuval Noah Harari", "Harvill Secker"));
    }

    public List<Book> getAllBooks() {
        return booksList;
    }

    public Book getBookById(int id) {
        for (Book book : booksList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; // Not found
    }

    public void addBook(Book book) {
        booksList.add(book);
    }

    public boolean removeBookById(int id) {
        return booksList.removeIf(book -> book.getId() == id);
    }
}

