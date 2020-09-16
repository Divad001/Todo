package com.projects.todo.exceptions.todoUserExceptions;

import com.projects.todo.models.ErrorMessage;

public class WrongPasswordException extends TodoUserException {

  public WrongPasswordException(String parameters) {
    this.parameters = parameters;
  }

  @Override
  public ErrorMessage getErrorMessage() {
    return new ErrorMessage("error", parameters);
  }
}
