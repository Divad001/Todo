package com.projects.todo.services.todoUserServices;

import com.projects.todo.dtos.TodoUserDTO;
import com.projects.todo.exceptions.todoUserExceptions.InvalidPassword;
import com.projects.todo.exceptions.todoUserExceptions.InvalidUsername;
import com.projects.todo.exceptions.todoUserExceptions.UsernameAlreadyTaken;
import com.projects.todo.exceptions.todoUserExceptions.WrongPasswordException;
import com.projects.todo.exceptions.todoUserExceptions.WrongUsernameException;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import java.util.List;

public interface TodoUserService {

  TodoUser findById(Long id);

  TodoUser findByUsername(String username);

  List<Todo> findAllTodoByUserId(Long id);

  void checkRegister(TodoUserDTO todoUserDTO)
      throws WrongUsernameException, WrongPasswordException, UsernameAlreadyTaken, InvalidUsername, InvalidPassword;

  void checkLogin(TodoUserDTO todoUserDTO)
      throws WrongUsernameException, WrongPasswordException, UsernameAlreadyTaken, InvalidUsername;

  void addUser(TodoUser todoUser);
}
