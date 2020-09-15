package com.projects.todo.services.todoServices;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import java.util.List;

public interface TodoService {

  void add(TodoDTO todoDTO, TodoUser todoUser) throws Exception;

  List<Todo> getAll();

  Todo getTodoByTodoId(Long id);

  void remove(Long id);

  void complete(Long id);
}
