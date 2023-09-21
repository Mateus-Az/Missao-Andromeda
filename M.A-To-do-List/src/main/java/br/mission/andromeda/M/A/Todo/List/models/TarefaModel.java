package br.mission.andromeda.M.A.Todo.List.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tarefas")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome")
    private String nome;

    @Size(max = 300)
    @Column(name = "sobre")
    private String sobre;

    @Column(name = "prioridade")
    private int prioridade;

    @Column(name = "data")
    private Date data;

    @Column(name = "concluida")
    private boolean concluida;
}
