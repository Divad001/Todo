package com.projects.todo.exceptions.todoUserExceptions;

import com.projects.todo.models.ErrorMessage;

public abstract class TodoUserException extends Exception {

  public abstract ErrorMessage getErrorMessage();
}
