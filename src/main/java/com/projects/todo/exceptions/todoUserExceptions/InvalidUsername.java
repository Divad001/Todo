package com.projects.todo.exceptions.todoUserExceptions;

import com.projects.todo.models.ErrorMessage;

public class InvalidUsername extends TodoUserException{

  public InvalidUsername(String parameters) {
    this.parameters = parameters;
  }

  @Override
  public ErrorMessage getErrorMessage() {
    return new ErrorMessage("error", parameters);
  }
}
