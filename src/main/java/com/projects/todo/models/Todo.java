package com.projects.todo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long todoId;
    protected String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date createdAt;
    protected boolean isComplete;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    protected TodoUser user;

    public Todo() {
    }

    public Todo(String content) {
        this.content = content;
        this.createdAt = new Date();
        this.isComplete = false;
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
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

    public TodoUser getUser() {
        return user;
    }

    public void setUser(TodoUser user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
