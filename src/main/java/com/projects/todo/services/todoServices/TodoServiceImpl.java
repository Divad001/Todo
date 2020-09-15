package com.projects.todo.services.todoServices;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.models.Todo;
import com.projects.todo.repositories.TodoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  private TodoRepo todoRepo;

  @Autowired
  public TodoServiceImpl(TodoRepo todoRepo) {
    this.todoRepo = todoRepo;
  }

  @Override
  public void add(TodoDTO todoDTO) throws Exception {
    if (todoDTO.getContent() == null || todoDTO.getContent().length() < 1) {
      throw new Exception();
    }
    Todo todo = new Todo(todoDTO.getContent());
  }

  @Override
  public List<Todo> getAllByUserId(Long id) {
    return todoRepo.findAllById(id);
  }

  @Override
  public Todo getTodoByTodoId(Long id) {
    return todoRepo.findById(id).orElse(null);
  }

  @Override
  public void remove(Long id) {
    todoRepo.deleteById(id);
  }

  @Override
  public void complete(Long id) {
    Optional<Todo> temp = todoRepo.findById(id);
    temp.ifPresent(todo -> todo.setComplete(true));
  }
}
