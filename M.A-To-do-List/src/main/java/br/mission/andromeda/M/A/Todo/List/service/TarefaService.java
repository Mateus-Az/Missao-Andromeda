package br.mission.andromeda.M.A.Todo.List.service;

import br.mission.andromeda.M.A.Todo.List.dtos.TarefaDto;
import br.mission.andromeda.M.A.Todo.List.exceptions.ListaVaziaException;
import br.mission.andromeda.M.A.Todo.List.exceptions.TarefaJaConcluidaException;
import br.mission.andromeda.M.A.Todo.List.exceptions.TarefaNaoEncontradaException;
import br.mission.andromeda.M.A.Todo.List.models.TarefaModel;
import br.mission.andromeda.M.A.Todo.List.repository.TarefaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public TarefaDto criarTarefa(TarefaDto dto) {
        if (dto.getData() == null) {
            dto.setData(LocalDateTime.now());
        }
        return modelMapper.map(repository.save(modelMapper.map(dto, TarefaModel.class)), TarefaDto.class);
    }

    public TarefaDto buscarTarefaPorId(Long id) {
        TarefaModel tarefa = repository.findById(id).orElseThrow(() -> new TarefaNaoEncontradaException());
        return modelMapper.map(tarefa, TarefaDto.class);
    }

    public List<TarefaDto> buscarTodasAsTarefas() {
        List<TarefaModel> all = repository.findAll();
        if (all.isEmpty()) {
            throw new ListaVaziaException();
        }
        return all.stream().map(tarefaModel -> modelMapper.map(tarefaModel, TarefaDto.class)).collect(Collectors.toList());
    }

    public String deletarTodasAsTarefas() {
        if (repository.count() < 1) {
            throw new ListaVaziaException();
        }
        repository.deleteAll();
        return "Todas as tarefas foram deletadas com sucesso";
    }


    public String deletarTarefaPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new TarefaNaoEncontradaException();
        }
        repository.deleteById(id);
        return "Tarefa deletada com sucesso";
    }

    public TarefaDto atualizarTarefaPodId(Long id, TarefaDto tarefaDto) {
        TarefaModel tarefaBanco = repository.findById(id).orElseThrow(() -> new TarefaNaoEncontradaException());

        tarefaDto.setId(id);
        modelMapper.map(tarefaDto, tarefaBanco);

        return modelMapper.map(tarefaBanco, TarefaDto.class);
    }


    public String concluirTarefa(Long id) {
        TarefaModel tarefa = repository.findById(id).orElseThrow(() -> new TarefaNaoEncontradaException());
        if (tarefa.getConcluida()) {
            throw new TarefaJaConcluidaException();
        }
        tarefa.setConcluida(true);
        repository.save(tarefa);
        return "Tarefa concluida com sucesso";
    }
}
