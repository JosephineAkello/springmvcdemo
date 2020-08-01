package com.example.springmvcdemo.model;

import java.util.Date;
import javax.validation.constraints.Size;

public class Todo {

    private int id;
    private String user;

    @Size(min=6, message="Enter atleast 6 characters")
    private String desc;

    private Date targeDate;
    private  boolean isDone;

    public Todo(int id, String user, String desc, Date targeDate, boolean isDone) {
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targeDate = targeDate;
        this.isDone = isDone;
    }

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
