package com.example.User_Management_System.controller;

import com.example.User_Management_System.dto.UserRequestDTO;
import com.example.User_Management_System.dto.UserResponseDTO;
import com.example.User_Management_System.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @PostMapping(path="/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping(path="/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(id, userRequestDTO);
    }
}
