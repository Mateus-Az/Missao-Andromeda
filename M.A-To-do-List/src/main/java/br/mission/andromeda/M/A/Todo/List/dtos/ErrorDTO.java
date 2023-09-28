package br.mission.andromeda.M.A.Todo.List.dtos;

import java.time.LocalDateTime;

public record ErrorDTO(int status, String message, LocalDateTime timestamp) {
}

