package com.projects.todo.exceptions.todoUserExceptions;

import com.projects.todo.models.ErrorMessage;

public class WrongUsernameException extends TodoUserException {

  public WrongUsernameException(String parameters) {
    this.parameters = parameters;
  }

  @Override
  public ErrorMessage getErrorMessage() {
    return new ErrorMessage("error", parameters);
  }
}
