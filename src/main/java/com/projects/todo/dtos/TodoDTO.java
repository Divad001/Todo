package com.projects.todo.dtos;

public class TodoDTO {

  private String content;

  public TodoDTO() {
  }

  public TodoDTO(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
