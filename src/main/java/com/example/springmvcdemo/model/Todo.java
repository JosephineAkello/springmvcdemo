package com.example.springmvcdemo.model;

import java.util.Date;

public class Todo {

    private int id;
    private String user;
    private String desc;
    private Date targeDate;
    private  boolean isDone;


    @Override
    public String toString() {
        return String.format(
                "ToString - Todo{id=%d, user='%s', desc='%s'," +
                        " targeDate=%s, isDone=%s}",
                id, user, desc, targeDate, isDone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;

        Todo todo = (Todo) o;

        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTargeDate() {
        return targeDate;
    }

    public void setTargeDate(Date targeDate) {
        this.targeDate = targeDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
