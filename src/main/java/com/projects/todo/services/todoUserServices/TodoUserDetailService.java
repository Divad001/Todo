package com.projects.todo.services.todoUserServices;

import com.projects.todo.models.TodoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoUserDetailService implements UserDetailsService {

  private TodoUserService todoUserService;

  @Autowired
  public TodoUserDetailService(TodoUserService todoUserService) {
    this.todoUserService = todoUserService;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    TodoUser temp = todoUserService.findByUsername(username);
    return new User(username, temp.getPassword(), new ArrayList<>());
  }
}
