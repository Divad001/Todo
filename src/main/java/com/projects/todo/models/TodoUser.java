package com.projects.todo.models;

import javax.persistence.*;

@Entity
public class TodoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(unique = true, length = 20)
    private String username;
    private String password;

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
}
