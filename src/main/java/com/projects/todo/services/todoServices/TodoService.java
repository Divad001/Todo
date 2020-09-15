package com.projects.todo.services.todoServices;

import com.projects.todo.models.Todo;
import java.util.List;

public interface TodoService {

  void add(Todo todo);

  List<Todo> getAllByUserId(Long id);

  Todo getTodoByTodoId(Long id);

  void remove(Long id);

  void complete(Long id);
}
