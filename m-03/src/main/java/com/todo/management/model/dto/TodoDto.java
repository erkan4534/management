package com.todo.management.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public class TodoDto {
    private Long id;
    private Long userId;
    private String title;
    private Boolean completed;
    private LocalDate insertDate;
}
