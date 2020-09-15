package com.projects.todo.repositories;

import com.projects.todo.models.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<Todo, Long> {

  List<Todo> findAll();
}
