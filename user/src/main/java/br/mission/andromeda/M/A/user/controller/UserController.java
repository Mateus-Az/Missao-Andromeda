package br.mission.andromeda.M.A.user.controller;

import br.mission.andromeda.M.A.user.dto.UserDTO;
import br.mission.andromeda.M.A.user.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> criarUser(@RequestBody @Valid UserDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarUser(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> buscarUserPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarUserPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> buscarTodosUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodosOsUsuarios());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UserDTO> atualizarUserPorId(@PathVariable Long id, @RequestBody UserDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarUserPorId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUserPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarUserPorId(id));
    }
}
