package com.breathe.breatheApi.controllers;

import com.breathe.breatheApi.api.UserDTO;
import com.breathe.breatheApi.api.UserDTOContainer;
import com.breathe.breatheApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{installationId}")
    public UserDTO getUserById(@PathVariable(value = "installationId") String installationId) {
        return userService.findByInstallationId(installationId);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTOContainer userDTOContainer) {
        return userService.createUser(userDTOContainer.getUserDTO().convertToUser());
    }
}
