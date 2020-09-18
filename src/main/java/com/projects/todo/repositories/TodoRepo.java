package com.projects.todo.repositories;

import com.projects.todo.models.Todo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<Todo, Long> {

  List<Todo> findAll();

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM todo WHERE todo_id = ?1", nativeQuery = true)
  void deleteById(Long id);
}
