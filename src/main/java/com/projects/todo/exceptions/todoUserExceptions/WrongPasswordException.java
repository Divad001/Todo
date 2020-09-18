package com.projects.todo.exceptions.todoUserExceptions;

import com.projects.todo.models.ErrorMessage;

public class WrongPasswordException extends TodoUserException {

  public WrongPasswordException(String parameters) {
    super(parameters);
  }

  @Override
  public ErrorMessage getErrorMessage() {
    return new ErrorMessage("error", parameters);
  }
}
