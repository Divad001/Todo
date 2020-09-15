package com.projects.todo.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class TodoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long userId;
    @Column(unique = true, length = 20)
    protected String username;
    protected String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    protected List<Todo> todoList = new ArrayList<>();

    public TodoUser() {
    }

    public TodoUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
