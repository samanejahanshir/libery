package com.jahanshir.sm;

public class Book {
    private String name;
    private int id;
    private int count;

    public Book() {
    }

    public Book(String name, int id, int count) {
        this.name = name;
        this.id = id;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


}
