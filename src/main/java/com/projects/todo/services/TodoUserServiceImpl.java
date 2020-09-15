package com.projects.todo.services;

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
    public void addUser(TodoUser todoUser) {
        todoUserRepo.save(todoUser);
    }
}
