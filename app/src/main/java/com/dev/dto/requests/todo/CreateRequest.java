package com.dev.dto.requests.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateRequest {

    @NotBlank
    private String content;
    @NotNull
    private Boolean isDone;
}
