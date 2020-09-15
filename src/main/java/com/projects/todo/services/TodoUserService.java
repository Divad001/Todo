package com.projects.todo.services;

import com.projects.todo.dtos.TodoUserDTO;
import com.projects.todo.exceptions.todoUserExceptions.WrongPasswordException;
import com.projects.todo.exceptions.todoUserExceptions.WrongUsernameException;
import com.projects.todo.models.TodoUser;

public interface TodoUserService {

    TodoUser findByUsername(String username);

    void checkRegister(TodoUserDTO todoUserDTO)
        throws WrongUsernameException, WrongPasswordException;

    void checkLogin(TodoUserDTO todoUserDTO) throws WrongUsernameException, WrongPasswordException;

    void addUser(TodoUser todoUser);
}
