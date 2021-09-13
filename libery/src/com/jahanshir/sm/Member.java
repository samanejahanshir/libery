package com.jahanshir.sm;

public class Member {
    private String name;
    private String birthDate;
    private int id;
    private Book[] books = new Book[5];
    private int indexBook = 0;

    public int getIndexBook() {
        return indexBook;
    }

    public void setIndexBook(int indexBook) {
        this.indexBook = indexBook;
    }

    public Member() {
    }

    public Member(String name, String birthDate, int id) {
        this.name = name;
        this.birthDate = birthDate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book[] getBooks() {
        return books;
    }

    public Book getBooks(int indexBook) {
        return books[indexBook];
    }

    public void setBooks(Book[] book) {
        this.books = book;
    }

    public void addBooks(Book book) {
        this.books[this.indexBook] = book;
    }

    public boolean returnBook(int id) {
        int index = -1;
        for (int i = 0; i < this.indexBook; i++) {
            if (books[i].getId() == id) {
                index = i;
            }
        }
        if (index != -1) {
            books[index] = null;
            Book[] tempBook = new Book[this.indexBook - 1];
            int k = 0;
            for (int i = 0; i < this.books.length; i++) {
                if (books[i] != null) {
                    tempBook[k] = new Book();
                    tempBook[k++] = books[i];
                }
            }

            setBooks(tempBook);
            --this.indexBook;
            return true;
        }
        return false;
    }


}
