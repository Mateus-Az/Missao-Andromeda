package br.mission.andromeda.M.A.Todo.List.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDateTime;


@Getter
@Setter
public class TarefaDto {

    private long id;
    @NotNull(message = "tarefa precisa ter um nome")
    @Size(min = 1, max = 200)
    private String nome;
    @Size(min = 1, max = 300)
    private String sobre;
    private int prioridade;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime data;

    private boolean concluida;
}
