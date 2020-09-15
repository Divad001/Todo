package com.projects.todo.services;

import com.projects.todo.models.TodoUser;

public interface TodoUserService {

    TodoUser findByUsername(String username);

    void addUser(TodoUser todoUser);
}
