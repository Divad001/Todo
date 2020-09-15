package com.projects.todo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long ID;
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date createdAt;
    protected boolean isComplete;
    @ManyToOne
    protected TodoUser todoUser;

    public Todo() {
    }

    public Todo(Date createdAt, boolean isComplete) {
        this.createdAt = createdAt;
        this.isComplete = isComplete;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public TodoUser getTodoUser() {
        return todoUser;
    }

    public void setTodoUser(TodoUser todoUser) {
        this.todoUser = todoUser;
    }
}
