package com.projects.todo.services.todoUserServices;

import com.projects.todo.dtos.TodoUserDTO;
import com.projects.todo.exceptions.todoUserExceptions.InvalidPassword;
import com.projects.todo.exceptions.todoUserExceptions.InvalidUsername;
import com.projects.todo.exceptions.todoUserExceptions.UsernameAlreadyTaken;
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
  public List<Todo> findAllTodoByUserId(Long id) {
    return findById(id).getTodoList();
  }

  @Override
  public void checkRegister(TodoUserDTO todoUserDTO)
      throws UsernameAlreadyTaken, InvalidUsername, InvalidPassword {
    checkRegisterCredentialsInput(todoUserDTO);
    TodoUser todoUser = new TodoUser(todoUserDTO.getUsername(), todoUserDTO.getPassword());
    addUser(todoUser);
  }


  @Override
  public void checkLogin(TodoUserDTO todoUserDTO)
      throws WrongPasswordException, WrongUsernameException {
    checkLoginCredentialsInput(todoUserDTO);
  }

  @Override
  public void addUser(TodoUser todoUser) {
    todoUserRepo.save(todoUser);
  }

  private void checkRegisterCredentialsInput(
      TodoUserDTO todoUserDTO)
      throws UsernameAlreadyTaken, InvalidUsername, InvalidPassword {
    if (todoUserDTO.getUsername() == null || todoUserDTO.getUsername().length() < 5) {
      throw new InvalidUsername("Invalid username: '" + todoUserDTO.getUsername()
          + "' . Username must contain at least 5 characters");
    } else if (todoUserRepo.findByUsername(todoUserDTO.getUsername()).isPresent()) {
      throw new UsernameAlreadyTaken(
          "Username: '" + todoUserDTO.getUsername() + "' is already taken");
    }
    if (todoUserDTO.getPassword() == null || todoUserDTO.getPassword().length() < 5) {
      throw new InvalidPassword(
          "Password must contain at least 5 characters.");
    }
  }

  private void checkLoginCredentialsInput(TodoUserDTO todoUserDTO)
      throws WrongUsernameException, WrongPasswordException {
    if (todoUserDTO.getUsername() == null
        || todoUserRepo.findByUsername(todoUserDTO.getUsername()).isEmpty()) {
      throw new WrongUsernameException(
          "Username: '" + todoUserDTO.getUsername() + "' does not exist.");
    } else if (!todoUserRepo.findByUsername(todoUserDTO.getUsername()).get().getPassword()
        .equals(todoUserDTO.getPassword())) {
      throw new WrongPasswordException("Wrong password");
    }
  }
}
