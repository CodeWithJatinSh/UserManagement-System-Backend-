package com.example.User_Management_System.service;


import com.example.User_Management_System.dto.UserRequestDTO;
import com.example.User_Management_System.dto.UserResponseDTO;

import java.util.List;

public interface UserService{

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
    void deleteUser(Long id);
    UserResponseDTO getUserById(Long id); // good to have
    List<UserResponseDTO> getAllUsers();
}