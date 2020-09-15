package com.projects.todo.controllers;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.models.Todo;
import com.projects.todo.services.todoServices.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

  private TodoService todoService;

  @Autowired
  public TodoRestController(TodoService todoService) {
    this.todoService = todoService;
  }


  @GetMapping("/todos/{id}")
  public ResponseEntity<?> getAllByUserId(@PathVariable Long id) {
    List<Todo> todoList = todoService.getAllByUserId(id);
    return new ResponseEntity<>(todoList, HttpStatus.OK);
  }

  @GetMapping("/todo/{id}")
  public ResponseEntity<?> getTodoByTodoId(@PathVariable Long id) {
    Todo todo = todoService.getTodoByTodoId(id);
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<?> addTodo(TodoDTO todoDTO) throws Exception {
    todoService.add(todoDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/complete/{id}")
  public ResponseEntity<?> completeTodo(@PathVariable Long id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id]")
  public ResponseEntity<?> removeTodo(@PathVariable Long id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
