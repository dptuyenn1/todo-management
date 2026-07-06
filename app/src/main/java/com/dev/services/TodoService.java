package com.dev.services;

import com.dev.dto.requests.todo.CreateRequest;
import com.dev.dto.requests.todo.UpdateRequest;
import com.dev.dto.responses.todo.TodoResponse;
import com.dev.models.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoService {

    Page<TodoResponse> getAll(Pageable pageable);

    TodoResponse create(CreateRequest request);

    Todo findById(long id);

    TodoResponse getById(long id);

    TodoResponse update(long id, UpdateRequest request);

    void delete(long id);
}
