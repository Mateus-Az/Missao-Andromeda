package br.mission.andromeda.M.A.user.service;

import br.mission.andromeda.M.A.user.dto.UserDTO;
import br.mission.andromeda.M.A.user.model.UserModel;
import br.mission.andromeda.M.A.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO criarUser(UserDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map((dto, UserModel.class)), UserDTO.class);
    }
}
