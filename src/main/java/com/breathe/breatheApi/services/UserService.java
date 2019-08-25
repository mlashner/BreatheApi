package com.breathe.breatheApi.services;

import com.breathe.breatheApi.api.UserDTO;
import com.breathe.breatheApi.core.User;
import com.breathe.breatheApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::convertUserToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        return UserDTO.convertUserToUserDTO(userRepository.findById(id).orElse(null));
    }

    public UserDTO findByInstallationId(String installationId) {
        return UserDTO.convertUserToUserDTO(userRepository.findByInstallationId(installationId).orElse(null));
    }

    public UserDTO createUser(User user) {
        // TODO: check if user email exists before creating new user
        return UserDTO.convertUserToUserDTO(userRepository.save(user));
    }
}
