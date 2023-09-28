package br.mission.andromeda.M.A.Todo.List.controller;


import br.mission.andromeda.M.A.Todo.List.dtos.TarefaDto;
import br.mission.andromeda.M.A.Todo.List.models.TarefaModel;
import br.mission.andromeda.M.A.Todo.List.repository.TarefaRepository;
import br.mission.andromeda.M.A.Todo.List.service.TarefaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaDto> criarTarefa(@RequestBody @Valid TarefaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarTarefa(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaDto>> buscarTodasAsTarefas() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodasAsTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> buscarTarefaPorId(@PathVariable @NotNull Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTarefaPorId(id));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarTarefaPorid(@PathVariable @NotNull Long id, @RequestBody TarefaDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarTarefaPodId(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity concluirTarefaPorId(@PathVariable @NotNull Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.concluirTarefa(id));
    }

    @DeleteMapping
    public ResponseEntity deletarTodasAsTarefas() {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarTodasAsTarefas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTarefaPorId(@PathVariable @NotNull Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarTarefaPorId(id));
    }
}



