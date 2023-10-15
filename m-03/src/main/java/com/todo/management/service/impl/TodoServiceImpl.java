package com.todo.management.service.impl;

import com.todo.management.exception.RecordNotFoundException;
import com.todo.management.model.Todo;
import com.todo.management.model.dto.TodoDto;
import com.todo.management.repository.TodoRepository;
import com.todo.management.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final RestTemplate restTemplate;
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<TodoDto> findAllTodos() {
        Todo[] todos =restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", Todo[].class);
        List<Todo> todoList = Arrays.asList(todos);
        todoList.stream().forEach(post -> {
            post.setInsertDate(LocalDate.of
                    (LocalDateTime.now().getYear(), LocalDateTime.now().getMonth() ,LocalDateTime.now().getDayOfMonth()));
            todoRepository.save(post);
        });
        return modelMapper.map(todoList, new TypeToken<List<TodoDto>>(){}.getType());
    }

    @Override
    public List<TodoDto> findByCompleted(Boolean completed) {
       List<Todo> todos= todoRepository.findByCompleted(completed);
       return modelMapper.map(todos, new TypeToken<List<TodoDto>>(){}.getType());
    }

    @Override
    public TodoDto findById(Long id) {
       Todo todo= todoRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Todo not found with ID:"+id));
       return this.modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> findByUserId(Long userId) {
        List<Todo> todos =todoRepository.findByUserId(userId);
        if(CollectionUtils.isEmpty(todos)){
            throw new RecordNotFoundException("Todo not found with userId:"+userId);
        }
        return modelMapper.map(todos, new TypeToken<List<TodoDto>>(){}.getType());
    }

    @Override
    public String saveTodo(TodoDto todoDto) {
        Todo todoEntity = this.modelMapper.map(todoDto, Todo.class);
        todoRepository.save(todoEntity);
        return "success";
    }
}
