package com.projects.todo.exceptions.todoExceptions;

import com.projects.todo.models.ErrorMessage;

public class WrongTodoException extends TodoException {

  public WrongTodoException(String parameters) {
    super(parameters);
  }

  @Override
  public ErrorMessage getErrorMessage() {
    return new ErrorMessage("error", parameters);
  }
}
