package com.todo.management.service;

import com.todo.management.model.Todo;
import com.todo.management.model.dto.TodoDto;
import java.util.List;
import java.util.Optional;

public interface TodoService {
  List<TodoDto> findAllTodos();
  List<TodoDto> findByCompleted(Boolean completed);
  TodoDto findById(Long id);
  List<TodoDto> findByUserId(Long userId);
  String saveTodo(TodoDto todoDto);
}
