package com.dev.services.impl;

import com.dev.dto.requests.todo.CreateRequest;
import com.dev.dto.requests.todo.UpdateRequest;
import com.dev.dto.responses.todo.TodoResponse;
import com.dev.exceptions.NotFoundException;
import com.dev.mappers.TodoMapper;
import com.dev.models.Todo;
import com.dev.repositories.TodoRepository;
import com.dev.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public Page<TodoResponse> getAll(Pageable pageable) {
        Page<Todo> page = todoRepository.findAll(pageable);

        return page.map(todoMapper::toResponse);
    }

    @Override
    public TodoResponse create(CreateRequest request) {
        Todo todo = todoMapper.toModel(request);

        return todoMapper.toResponse(todoRepository.save(todo));
    }

    @Override
    public Todo findById(long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public TodoResponse getById(long id) {
        Todo todo = findById(id);

        if (todo == null)
            throw new NotFoundException(String.format("Todo with id: %d is not found", id));

        return todoMapper.toResponse(todo);
    }

    @Override
    public TodoResponse update(long id, UpdateRequest request) {
        Todo todo = findById(id);

        if (todo == null)
            throw new NotFoundException(String.format("Todo with id: %d is not found", id));

        todoMapper.updateModel(request, todo);

        return todoMapper.toResponse(todoRepository.save(todo));
    }

    @Override
    public void delete(long id) {
        Todo todo = findById(id);

        if (todo == null)
            throw new NotFoundException(String.format("Todo with id: %d is not found", id));

        todoRepository.delete(todo);
    }
}
