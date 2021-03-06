package com.projects.todo.controllers;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.exceptions.todoExceptions.WrongTodoIdException;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import com.projects.todo.services.todoServices.TodoService;
import com.projects.todo.services.todoUserServices.TodoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

  private TodoService todoService;
  private TodoUserService todoUserService;

  @Autowired
  public TodoRestController(TodoService todoService, TodoUserService todoUserService) {
    this.todoService = todoService;
    this.todoUserService = todoUserService;
  }


  @GetMapping("/todos")
  public ResponseEntity<?> getAllByUserId() {
    return new ResponseEntity<>(todoUserService.findAllTodoByUserId(extractUser().getUserId()),
      HttpStatus.OK);
  }

  @GetMapping("/todo/{id}")
  public ResponseEntity<?> getTodoByTodoId(@PathVariable Long id) throws WrongTodoIdException {
    Todo temp = todoService.getTodoByTodoId(extractUser().getUserId(), id);
    if (temp != null) {
      return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }

  @PostMapping("/add")
  public ResponseEntity<?> addTodo(@RequestBody TodoDTO todoDTO) throws Exception {
    Todo todo = todoService.add(todoDTO, todoUserService.findById(extractUser().getUserId()));
    return new ResponseEntity<>("Todo: '" + todo.getContent() + "' has been added.", HttpStatus.OK);
  }

  @PutMapping("/complete/{id}")
  public ResponseEntity<?> completeTodo(@PathVariable Long id) throws WrongTodoIdException {
    todoService.complete(extractUser().getUserId(), id);
    Todo todo = todoService.getTodoByTodoId(extractUser().getUserId(), id);
    return new ResponseEntity<>(
      "Todo: '" + todo.getContent() + "' status has been set to completed.",
      HttpStatus.OK);
  }

  @PutMapping("/incomplete/{id}")
  public ResponseEntity<?> inComplete(@PathVariable Long id) throws WrongTodoIdException {
    todoService.inComplete(extractUser().getUserId(), id);
    Todo todo = todoService.getTodoByTodoId(extractUser().getUserId(), id);
    return new ResponseEntity<>(
      "Todo: '" + todo.getContent() + "' status has been set to uncompleted.", HttpStatus.OK);
  }

  @DeleteMapping("/remove/{id}")
  public ResponseEntity<?> removeTodo(@PathVariable Long id) throws WrongTodoIdException {
    Todo temp = todoService.remove(extractUser().getUserId(), id);
    return new ResponseEntity<>("Todo: '" + temp.getContent() + "' has been deleted.",
      HttpStatus.OK);
  }

  private TodoUser extractUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    return todoUserService.findByUsername(username);
  }
}
