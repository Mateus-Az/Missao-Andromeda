package br.mission.andromeda.M.A.Todo.List.service;

import br.mission.andromeda.M.A.Todo.List.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;
}
