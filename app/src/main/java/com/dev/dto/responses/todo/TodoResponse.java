package com.dev.dto.responses.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TodoResponse {

    private String content;
    private Boolean isDone;
}
