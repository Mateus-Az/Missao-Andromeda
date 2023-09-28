package br.mission.andromeda.M.A.Todo.List.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
public class TarefaDto {

    private Long id;
    @NotNull(message = "tarefa precisa ter um nome")
    @Size(min = 1, max = 200)
    private String nome;
    @Size(min = 1, max = 300)
    private String sobre;
    private Integer prioridade;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime data;
    private Boolean concluida;
}
