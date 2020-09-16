package com.projects.todo.services.todoServices;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import java.util.List;

public interface TodoService {

  void add(TodoDTO todoDTO, TodoUser todoUser) throws Exception;

  Todo getTodoByTodoId(Long userId, Long id);

  void complete(Long userId, Long id);

  void inComplete(Long userId, Long id);

  void remove(Long userId, Long id);
}
