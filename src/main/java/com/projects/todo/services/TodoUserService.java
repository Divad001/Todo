package com.projects.todo.services;

import com.projects.todo.dtos.TodoUserDTO;
import com.projects.todo.exceptions.WrongUsernameException;
import com.projects.todo.models.TodoUser;

public interface TodoUserService {

    TodoUser findByUsername(String username);

    void checkRegister(TodoUserDTO todoUserDTO) throws WrongUsernameException;

    void addUser(TodoUser todoUser);
}
