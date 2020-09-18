package com.projects.todo.controllers;

import com.projects.todo.dtos.TodoUserDTO;
import com.projects.todo.exceptions.todoUserExceptions.InvalidPassword;
import com.projects.todo.exceptions.todoUserExceptions.InvalidUsername;
import com.projects.todo.exceptions.todoUserExceptions.UsernameAlreadyTaken;
import com.projects.todo.exceptions.todoUserExceptions.WrongPasswordException;
import com.projects.todo.exceptions.todoUserExceptions.WrongUsernameException;
import com.projects.todo.services.todoUserServices.TodoUserService;
import com.projects.todo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoUserRestController {

  private TodoUserService todoUserService;
  private UserDetailsService userDetailsService;
  private JwtUtil jwtUtil;

  @Autowired
  public TodoUserRestController(TodoUserService todoUserService,
      UserDetailsService userDetailsService, JwtUtil jwtUtil) {
    this.todoUserService = todoUserService;
    this.userDetailsService = userDetailsService;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody TodoUserDTO todoUserDTO)
      throws WrongUsernameException, WrongPasswordException, InvalidPassword, UsernameAlreadyTaken, InvalidUsername {
    todoUserService.checkRegister(todoUserDTO);
    return new ResponseEntity<>(todoUserService.findByUsername(todoUserDTO.getUsername()),
        HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody TodoUserDTO todoUserDTO)
      throws WrongUsernameException, WrongPasswordException, UsernameAlreadyTaken, InvalidUsername {
    todoUserService.checkLogin(todoUserDTO);

    final UserDetails userDetails = userDetailsService
        .loadUserByUsername(todoUserDTO.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails, 60);
    return new ResponseEntity<>(jwt, HttpStatus.OK);
  }
}
