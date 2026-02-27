package com.example.User_Management_System.dto;

import java.util.HashSet;
import java.util.Set;

import com.example.User_Management_System.entity.Department;
import com.example.User_Management_System.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String fullName;
    private String address;
    private String mobile;        // String, not int
    private String email;
    private Set<RoleDTO> roles = new HashSet<>();        // use RoleDTO
    private DepartmentDTO department;
}