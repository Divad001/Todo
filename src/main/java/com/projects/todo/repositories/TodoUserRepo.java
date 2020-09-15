package com.projects.todo.repositories;

import com.projects.todo.models.Todo;
import com.projects.todo.models.TodoUser;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoUserRepo extends CrudRepository<TodoUser, Long> {

    Optional<TodoUser> findByUsername(String username);

//    List<Todo> findBy(Long id);
}
