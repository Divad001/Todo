package com.projects.todo.exceptions;

import com.projects.todo.exceptions.todoExceptions.WrongTodoException;
import com.projects.todo.exceptions.todoExceptions.WrongTodoIdException;
import com.projects.todo.exceptions.todoUserExceptions.InvalidPassword;
import com.projects.todo.exceptions.todoUserExceptions.InvalidUsername;
import com.projects.todo.exceptions.todoUserExceptions.UsernameAlreadyTaken;
import com.projects.todo.exceptions.todoUserExceptions.WrongPasswordException;
import com.projects.todo.exceptions.todoUserExceptions.WrongUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler {

  public TodoExceptionHandler() {
  }

  //region TodoUserExceptions

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

  //endregion

  //region TodoExceptions

  @ExceptionHandler(value = WrongTodoException.class)
  public ResponseEntity<?> wrongTodoException(WrongTodoException e) {
    return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = WrongTodoIdException.class)
  public ResponseEntity<?> wrongTodoIdException(WrongTodoIdException e) {
    return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
  }

  //endregion
}
