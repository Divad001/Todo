package com.projects.todo.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class TodoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long ID;
    @Column(unique = true, length = 20)
    protected String username;
    protected String password;
    @OneToMany(mappedBy = "todoUser")
    protected List<Todo> todoList;

    public TodoUser() {
    }

    public TodoUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
