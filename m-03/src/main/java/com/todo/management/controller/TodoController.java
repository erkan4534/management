package com.todo.management.controller;

import com.todo.management.model.dto.TodoDto;
import com.todo.management.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    @GetMapping("/todos")
    public List<TodoDto> findAllTodos() {
        return todoService.findAllTodos();
    }

    @GetMapping("/todos/completed")
    public List<TodoDto> findByCompleted(@RequestParam Boolean completed) {
        return todoService.findByCompleted(completed);
    }

    @GetMapping("/todos/{id}")
    public TodoDto findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @GetMapping("/todos/userId")
    public  List<TodoDto>  findByUserId(@RequestParam Long userId) {
        return todoService.findByUserId(userId);
    }

    @PostMapping("/todos")
    public String saveTodo(TodoDto todoDto){
        return todoService.saveTodo(todoDto);
    }

}
