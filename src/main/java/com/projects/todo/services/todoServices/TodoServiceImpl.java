package com.projects.todo.services.todoServices;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.exceptions.todoExceptions.WrongTodoException;
import com.projects.todo.exceptions.todoExceptions.WrongTodoIdException;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import com.projects.todo.repositories.TodoRepo;
import com.projects.todo.services.todoUserServices.TodoUserService;
import java.util.List;
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
  public Todo add(TodoDTO todoDTO, TodoUser todoUser) throws WrongTodoException {
    if (todoDTO.getContent() == null || todoDTO.getContent().length() < 1) {
      throw new WrongTodoException("Todo can not be empty.");
    }
    Todo todo = new Todo(todoDTO.getContent());
    todo.setUser(todoUser);
    todoRepo.save(todo);
    return todo;
  }

  @Override
  public Todo getTodoByTodoId(Long userId, Long id) throws WrongTodoIdException {
    return checkUserTodoList(userId, id);
  }

  @Override
  public void complete(Long userId, Long id) throws WrongTodoIdException {
    Todo temp = checkUserTodoList(userId, id);
    temp.setComplete(true);
    todoRepo.save(temp);
  }

  @Override
  public void inComplete(Long userId, Long id) throws WrongTodoIdException {
    Todo temp = checkUserTodoList(userId, id);
    temp.setComplete(false);
    todoRepo.save(temp);
  }

  @Override
  public Todo remove(Long userId, Long id) throws WrongTodoIdException {
    Todo todo = checkUserTodoList(userId, id);
    todoRepo.deleteById(id);
    return todo;
  }

  private Todo checkUserTodoList(Long userId, Long id) throws WrongTodoIdException {
    List<Todo> todoList = todoUserService.findAllTodoByUserId(userId);
    for (Todo t : todoList) {
      if (t.getTodoId().equals(id)) {
        return t;
      }
    }
    throw new WrongTodoIdException(
      "Todo ID: '" + id.toString() + "' does not exist in your Todo List.");
  }
}
