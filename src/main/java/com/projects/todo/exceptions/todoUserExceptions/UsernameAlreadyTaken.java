package com.projects.todo.exceptions.todoUserExceptions;

import com.projects.todo.models.ErrorMessage;

public class UsernameAlreadyTaken extends TodoUserException {

  public UsernameAlreadyTaken(String parameters) {
    this.parameters = parameters;
  }

  @Override
  public ErrorMessage getErrorMessage() {
    return new ErrorMessage("error", parameters);
  }
}
