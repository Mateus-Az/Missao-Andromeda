package br.mission.andromeda.M.A.Todo.List.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "lista_tarefas")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tarefas")
    private List<TarefaModel> tarefaModels = new ArrayList<TarefaModel>();

    @Column(name = "quantidade")
    private int quantidade;
}
