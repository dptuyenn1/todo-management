package com.dev.mappers;

import com.dev.dto.requests.todo.CreateRequest;
import com.dev.dto.requests.todo.UpdateRequest;
import com.dev.dto.responses.todo.TodoResponse;
import com.dev.models.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoMapper {

    List<TodoResponse> toResponses(List<Todo> todos);

    TodoResponse toResponse(Todo todo);

    Todo toModel(CreateRequest request);

    void updateModel(UpdateRequest request, @MappingTarget Todo todo);
}
