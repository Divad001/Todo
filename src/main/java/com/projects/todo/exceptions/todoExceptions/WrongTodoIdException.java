package com.projects.todo.exceptions.todoExceptions;

import com.projects.todo.models.ErrorMessage;

public class WrongTodoIdException extends TodoException {

  public WrongTodoIdException(String parameters) {
    super(parameters);
  }

  @Override
  public ErrorMessage getErrorMessage() {
    return new ErrorMessage("error", parameters);
  }
}
