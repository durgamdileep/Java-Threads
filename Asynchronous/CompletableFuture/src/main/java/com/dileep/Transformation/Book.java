package com.dileep.Transformation;

public class Book {

    private int id;
    private String bookName;
    private String genre;
    private String author;
    private String publisher;

    // Constructor
    public Book(int id, String bookName, String genre, String author, String publisher) {
        this.id = id;
        this.bookName = bookName;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}

