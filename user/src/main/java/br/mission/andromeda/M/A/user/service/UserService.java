package br.mission.andromeda.M.A.user.service;

import br.mission.andromeda.M.A.user.dto.UserDTO;
import br.mission.andromeda.M.A.user.exceptions.ListaUserVaziaException;
import br.mission.andromeda.M.A.user.exceptions.UserNaoEncontradoException;
import br.mission.andromeda.M.A.user.model.UserModel;
import br.mission.andromeda.M.A.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO criarUser(UserDTO dto) {
        return modelMapper.map(repository
                .save(modelMapper.map(dto, UserModel.class)), UserDTO.class);
    }

    public UserDTO buscarUserPorId(Long id) {
        UserModel user  = repository.findById(id).orElseThrow(() -> new UserNaoEncontradoException());
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> buscarTodosOsUsers() {
        List<UserModel> all = repository.findAll();
        if (all.isEmpty()) {
            throw new ListaUserVaziaException();
        }
        return all.stream()
                .map(userModel -> modelMapper.map(userModel, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO atualizarUserPorId(Long id, UserDTO userDTO) {
        UserModel user  = repository.findById(id).orElseThrow(() -> new UserNaoEncontradoException());
        userDTO.setId(id);
        modelMapper.map(userDTO, user);
        return modelMapper.map(user, UserDTO.class);
    }

    public String deletarUserPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new UserNaoEncontradoException();
        }
        repository.deleteById(id);
        return "Usuário deletado com sucesso!";
    }

    public List<UserDTO> buscarTodosOsUsuarios() {
       return repository.findAll().stream().map(userModel -> modelMapper.map(userModel, UserDTO.class)).collect(Collectors.toList());
    }
}
