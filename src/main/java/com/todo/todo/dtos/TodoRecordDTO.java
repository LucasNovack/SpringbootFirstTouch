package com.todo.todo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoRecordDTO(@NotBlank String dsTodo, @NotNull boolean ieResolvido) {

}
