package com.projects.todo.repositories;

import com.projects.todo.models.TodoUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoUserRepo extends CrudRepository<TodoUser, Long> {

  Optional<TodoUser> findByUsername(String username);

}
