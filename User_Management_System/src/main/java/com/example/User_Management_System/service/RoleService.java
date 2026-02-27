package com.example.User_Management_System.service;

import com.example.User_Management_System.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(RoleDTO roleDTO);
    RoleDTO updateRole(Long id, RoleDTO roleDTO);
    void deleteRole(Long id);
    RoleDTO getRoleById(Long id);
    List<RoleDTO> getAllRoles();
}