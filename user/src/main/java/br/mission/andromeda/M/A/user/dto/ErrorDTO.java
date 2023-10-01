package br.mission.andromeda.M.A.user.dto;

import java.time.LocalDateTime;

public record ErrorDTO(int status, String message, LocalDateTime timestamp) {
}
