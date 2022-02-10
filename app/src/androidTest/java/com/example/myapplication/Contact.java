package com.example.myapplication;

public class Contact {
    private long id,passmarks,fullmarks;
    private String name;

    public Contact(long id, long passmarks, long fullmarks, String name) {
        this.id = id;
        this.passmarks = passmarks;
        this.fullmarks = fullmarks;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPassmarks() {
        return passmarks;
    }

    public void setPassmarks(long passmarks) {
        this.passmarks = passmarks;
    }

    public long getFullmarks() {
        return fullmarks;
    }

    public void setFullmarks(long fullmarks) {
        this.fullmarks = fullmarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
