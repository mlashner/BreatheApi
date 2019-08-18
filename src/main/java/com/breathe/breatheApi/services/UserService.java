package com.breathe.breatheApi.services;

import com.breathe.breatheApi.core.User;
import com.breathe.breatheApi.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "User not found for id :: " + id));
    }

    public User createUser(User user) {
        // TODO: check if user email exists before creating new user
        return userRepository.save(user);
    }
}
