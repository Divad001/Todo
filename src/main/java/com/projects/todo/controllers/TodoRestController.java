package com.projects.todo.controllers;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.models.Todo;
import com.projects.todo.services.todoServices.TodoService;
import com.projects.todo.services.todoUserServices.TodoUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


  @GetMapping("/todos/{id}")
  public ResponseEntity<?> getAllByUserId(@PathVariable Long id) {
    return new ResponseEntity<>(todoUserService.findAllTodoById(id), HttpStatus.OK);
  }

  @GetMapping("/todo/{id}")
  public ResponseEntity<?> getTodoByTodoId(@PathVariable Long id) {
    Todo todo = todoService.getTodoByTodoId(id);
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }

  @PostMapping("/add/{id}")
  public ResponseEntity<?> addTodo(@RequestBody TodoDTO todoDTO, @PathVariable Long id) throws Exception {
    todoService.add(todoDTO, todoUserService.findById(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/complete/{id}")
  public ResponseEntity<?> completeTodo(@PathVariable Long id) {
    todoService.complete(id);
    return new ResponseEntity<>(todoService.getTodoByTodoId(id), HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id]")
  public ResponseEntity<?> removeTodo(@PathVariable Long id) {
    todoService.remove(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
