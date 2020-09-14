package com.projects.todo.models;

import java.util.ArrayList;

public class User {

    protected Long ID;
    protected String name;
    protected ArrayList<String> list;

    public User(String name) {
        this.name = name;
        this.list = new ArrayList<String>();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getList() {
        return list;
    }
}
