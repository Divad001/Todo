package com.projects.todo.services.todoServices;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.models.Todo;
import java.util.List;

public interface TodoService {

  void add(TodoDTO todoDTO) throws Exception;

  List<Todo> getAllByUserId(Long id);

  Todo getTodoByTodoId(Long id);

  void remove(Long id);

  void complete(Long id);
}
