package com.projects.todo.services.todoServices;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.exceptions.todoExceptions.WrongTodoIdException;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import java.util.List;

public interface TodoService {

  Todo add(TodoDTO todoDTO, TodoUser todoUser) throws Exception;

  Todo getTodoByTodoId(Long userId, Long id) throws WrongTodoIdException;

  void complete(Long userId, Long id) throws WrongTodoIdException;

  void inComplete(Long userId, Long id) throws WrongTodoIdException;

  Todo remove(Long userId, Long id) throws WrongTodoIdException;
}
