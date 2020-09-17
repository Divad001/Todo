package com.projects.todo.exceptions.todoExceptions;

import com.projects.todo.models.ErrorMessage;

public abstract class TodoException extends Exception{

  protected String parameters;

  public TodoException(String parameters) {
    this.parameters = parameters;
  }

  public abstract ErrorMessage getErrorMessage();
}
