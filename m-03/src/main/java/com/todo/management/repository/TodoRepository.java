package com.todo.management.repository;

import com.todo.management.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository  extends JpaRepository<Todo, Long> {
    List<Todo> findByCompleted(Boolean completed);

    Optional<Todo> findById(Long id);

    List<Todo> findByUserId(Long id);
}
