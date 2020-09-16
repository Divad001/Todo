package com.projects.todo.exceptions;

import com.projects.todo.exceptions.todoUserExceptions.InvalidPassword;
import com.projects.todo.exceptions.todoUserExceptions.InvalidUsername;
import com.projects.todo.exceptions.todoUserExceptions.UsernameAlreadyTaken;
import com.projects.todo.exceptions.todoUserExceptions.WrongPasswordException;
import com.projects.todo.exceptions.todoUserExceptions.WrongUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler {

  public TodoExceptionHandler() {
  }

  @ExceptionHandler(value = InvalidUsername.class)
  public ResponseEntity<?> invalidUsernameException(InvalidUsername e) {
    return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = UsernameAlreadyTaken.class)
  public ResponseEntity<?> usernameAlreadyTaken(UsernameAlreadyTaken e) {
    return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = InvalidPassword.class)
  public ResponseEntity<?> invalidPassword(InvalidPassword e) {
    return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = WrongUsernameException.class)
  public ResponseEntity<?> wrongUserNameException(WrongUsernameException e) {
    return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = WrongPasswordException.class)
  public ResponseEntity<?> wrongPasswordException(WrongPasswordException e) {
    return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }
}
