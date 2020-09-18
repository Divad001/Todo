package com.projects.todo.exceptions.todoUserExceptions;

import com.projects.todo.models.ErrorMessage;

public abstract class TodoUserException extends Exception {

  protected String parameters;

  public TodoUserException(String parameters) {
    this.parameters = parameters;
  }

  public abstract ErrorMessage getErrorMessage();
}
