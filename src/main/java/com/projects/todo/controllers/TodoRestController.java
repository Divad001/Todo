package com.projects.todo.controllers;

import com.projects.todo.models.TodoUser;
import com.projects.todo.services.TodoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

    private final TodoUserService todoUserService;

    @Autowired
    public TodoRestController(TodoUserService todoUserService) {
        this.todoUserService = todoUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody TodoUser todoUser) {
        todoUserService.addUser(todoUser);
        return new ResponseEntity<>(todoUser, HttpStatus.OK);
    }
}
