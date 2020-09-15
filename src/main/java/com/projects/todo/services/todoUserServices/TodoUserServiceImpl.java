package com.projects.todo.services.todoUserServices;

import com.projects.todo.dtos.TodoUserDTO;
import com.projects.todo.exceptions.todoUserExceptions.WrongPasswordException;
import com.projects.todo.exceptions.todoUserExceptions.WrongUsernameException;
import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import com.projects.todo.repositories.TodoUserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoUserServiceImpl implements TodoUserService {

  private TodoUserRepo todoUserRepo;

  @Autowired
  public TodoUserServiceImpl(TodoUserRepo todoUserRepo) {
    this.todoUserRepo = todoUserRepo;
  }

  @Override
  public TodoUser findById(Long id) {
    return todoUserRepo.findById(id).orElse(null);
  }

  @Override
  public TodoUser findByUsername(String username) {
    return todoUserRepo.findByUsername(username).orElse(null);
  }

  @Override
  public List<Todo> findAllTodoById(Long id) {
    return findById(id).getTodoList();
  }

  @Override
  public void checkRegister(TodoUserDTO todoUserDTO)
      throws WrongUsernameException, WrongPasswordException {
    isTodoUserDTOUsernameAndPasswordValid(todoUserDTO);
    TodoUser todoUser = new TodoUser(todoUserDTO.getUsername(), todoUserDTO.getPassword());
    addUser(todoUser);
  }


  @Override
  public void checkLogin(TodoUserDTO todoUserDTO)
      throws WrongUsernameException, WrongPasswordException {
    isTodoUserDTOUsernameAndPasswordValid(todoUserDTO);
  }

  @Override
  public void addUser(TodoUser todoUser) {
    todoUserRepo.save(todoUser);
  }

  private void isTodoUserDTOUsernameAndPasswordValid(TodoUserDTO todoUserDTO)
      throws WrongUsernameException, WrongPasswordException {
    if (todoUserDTO.getUsername() == null || todoUserDTO.getUsername().length() < 1) {
     throw new WrongUsernameException(todoUserDTO.getUsername());
    }
    if (todoUserDTO.getPassword() == null || todoUserDTO.getPassword().length() < 1) {
      throw new WrongPasswordException(todoUserDTO.getPassword());
    }
  }
}
