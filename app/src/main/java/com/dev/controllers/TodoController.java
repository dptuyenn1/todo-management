package com.dev.controllers;

import com.dev.dto.requests.todo.CreateRequest;
import com.dev.dto.requests.todo.UpdateRequest;
import com.dev.dto.responses.api.PageResponse;
import com.dev.dto.responses.api.SuccessResponse;
import com.dev.dto.responses.todo.TodoResponse;
import com.dev.services.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public PageResponse<TodoResponse> getAll(@ParameterObject Pageable pageable) {
        return new PageResponse<>("Get all todos successfully", todoService.getAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SuccessResponse<TodoResponse> getById(@PathVariable long id) {
        return new SuccessResponse<>("Get todo successfully", todoService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public SuccessResponse<TodoResponse> create(@RequestBody @Valid CreateRequest request) {
        return new SuccessResponse<>("Create todo successfully", todoService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public SuccessResponse<TodoResponse> update(@PathVariable long id, @RequestBody @Valid UpdateRequest request) {
        return new SuccessResponse<>("Update todo successfully", todoService.update(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<TodoResponse> delete(@PathVariable long id) {
        todoService.delete(id);

        return new SuccessResponse<>("Delete todo successfully", HttpStatus.CREATED);
    }
}
