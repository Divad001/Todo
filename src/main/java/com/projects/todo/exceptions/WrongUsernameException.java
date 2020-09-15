package com.projects.todo.exceptions;

import com.projects.todo.models.ErrorMessage;

public class WrongUsernameException extends Exception{

    private String parameters;

    public WrongUsernameException(String parameters) {
        this.parameters = parameters;
    }

    public ErrorMessage getErrorMessage() {
        return new ErrorMessage("error", parameters);
    }
}
