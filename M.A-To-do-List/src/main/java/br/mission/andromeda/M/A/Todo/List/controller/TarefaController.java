package br.mission.andromeda.M.A.Todo.List.controller;


import br.mission.andromeda.M.A.Todo.List.dtos.TarefaDto;
import br.mission.andromeda.M.A.Todo.List.models.TarefaModel;
import br.mission.andromeda.M.A.Todo.List.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<TarefaModel> saveTarefa(@RequestBody @Valid TarefaDto tarefaDto) {
        var tarefaModel = new TarefaModel();
        BeanUtils.copyProperties(tarefaDto, tarefaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> getAllTarefas() {
        List<TarefaModel> tarefaList = tarefaRepository.findAll();
        if(!tarefaList.isEmpty()) {
                return (ResponseEntity<List<TarefaModel>>) tarefaList;
            }
        throw new RuntimeException("lista vazia");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> updateTarefa(@PathVariable(value = "id") long id,
                                               @RequestBody @Valid TarefaDto tarefaDto) {
        Optional<TarefaModel> tarefa0 = tarefaRepository.findById(id);
        if (tarefa0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }
        var tarefaModel = tarefa0.get();
        BeanUtils.copyProperties(tarefaDto, tarefaModel);
        return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.save(tarefaModel));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteTarefa(@PathVariable(value = "id") long id) {
        Optional<TarefaModel> tarefa0 = tarefaRepository.findById(id);
        if(tarefa0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }
        tarefaRepository.delete(tarefa0.get());
        return ResponseEntity.status(HttpStatus.OK).body(tarefa0.get());
    }
}



