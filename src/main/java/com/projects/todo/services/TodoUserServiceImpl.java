package com.projects.todo.services;

import com.projects.todo.dtos.TodoUserDTO;
import com.projects.todo.exceptions.WrongUsernameException;
import com.projects.todo.models.TodoUser;
import com.projects.todo.repositories.TodoUserRepo;
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
    public TodoUser findByUsername(String username) {
        return todoUserRepo.findByUsername(username).orElse(null);
    }

    @Override
    public void checkRegister(TodoUserDTO todoUserDTO) throws WrongUsernameException {
        if (todoUserDTO.getUsername() == null || todoUserDTO.getUsername().length() < 1 || findByUsername(todoUserDTO.getUsername()) != null) {
            throw new WrongUsernameException(todoUserDTO.getUsername());
        }
        TodoUser todoUser = new TodoUser(todoUserDTO.getUsername(), todoUserDTO.getPassword());
        addUser(todoUser);
    }

    @Override
    public void addUser(TodoUser todoUser) {
        todoUserRepo.save(todoUser);
    }
}
