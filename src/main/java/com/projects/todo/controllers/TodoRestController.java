package com.projects.todo.controllers;

import com.projects.todo.dtos.TodoDTO;
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


  @GetMapping("/todos/{id}")
  public ResponseEntity<?> getAllByUserId(@PathVariable Long id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/todo/{id}")
  public ResponseEntity<?> getTodoByTodoId(@PathVariable Long id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<?> addTodo(TodoDTO todoDTO) {
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
