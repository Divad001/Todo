package com.projects.todo.services.todoServices;

import com.projects.todo.dtos.TodoDTO;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import com.projects.todo.repositories.TodoRepo;
import com.projects.todo.repositories.TodoUserRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  private TodoRepo todoRepo;
  private TodoUserRepo todoUserRepo;

  @Autowired
  public TodoServiceImpl(TodoRepo todoRepo, TodoUserRepo todoUserRepo) {
    this.todoRepo = todoRepo;
    this.todoUserRepo = todoUserRepo;
  }

  @Override
  public void add(TodoDTO todoDTO, TodoUser todoUser) throws Exception {
    if (todoDTO.getContent() == null || todoDTO.getContent().length() < 1) {
      throw new Exception();
    }
    Todo todo = new Todo(todoDTO.getContent());
    todo.setUser(todoUser);
    todoRepo.save(todo);

  }

  @Override
  public List<Todo> getAll() {
    return todoRepo.findAll();
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
