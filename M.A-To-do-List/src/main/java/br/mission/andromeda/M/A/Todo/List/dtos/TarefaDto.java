package br.mission.andromeda.M.A.Todo.List.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

public record TarefaDto(
        @NotNull (message = "tarefa precisa ter um nome")
        @Size(min = 1, max = 200)
        String nome,

        @Size(min = 1, max = 300)
        String sobre,
        int prioridade,
        Date data,
        boolean concluida
) {

}
