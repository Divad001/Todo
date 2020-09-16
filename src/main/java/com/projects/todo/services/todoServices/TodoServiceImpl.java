package com.projects.todo.services.todoServices;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import com.projects.todo.repositories.TodoRepo;
import com.projects.todo.repositories.TodoUserRepo;
import com.projects.todo.services.todoUserServices.TodoUserService;
import com.sun.xml.bind.v2.TODO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  private TodoRepo todoRepo;
  private TodoUserService todoUserService;

  @Autowired
  public TodoServiceImpl(TodoRepo todoRepo, TodoUserService todoUserService) {
    this.todoRepo = todoRepo;
    this.todoUserService = todoUserService;
  }

  @Override
  public void add(TodoDTO todoDTO, TodoUser todoUser) throws Exception {
    if (todoDTO.getContent() == null || todoDTO.getContent().length() < 1) {
      throw new Exception();
    }
    Todo todo = new Todo(todoDTO.getContent());
    todo.setUser(todoUser);
    todoRepo.save(todo);

  }

  @Override
  public Todo getTodoByTodoId(Long userId, Long id) {
    return checkUserTodoList(userId, id);
  }

  @Override
  public void complete(Long userId, Long id) {
    Todo temp = checkUserTodoList(userId, id);
    if (temp != null) {
      temp.setComplete(true);
      todoRepo.save(temp);
    }
  }

  @Override
  public void inComplete(Long userId, Long id) {
    Todo temp = checkUserTodoList(userId, id);
    if (temp != null) {
      temp.setComplete(false);
      todoRepo.save(temp);
    }
  }

  @Override
  public void remove(Long userId, Long id) {
    if (checkUserTodoList(userId, id) != null) {
      todoRepo.deleteById(id);
    }
  }

  private Todo checkUserTodoList(Long userId, Long id) {
    List<Todo> todoList = todoUserService.findAllTodoByUserId(userId);
    for (Todo t : todoList) {
      if (t.getTodoId().equals(id)) {
        return t;
      }
    }
    return null;
  }
}
