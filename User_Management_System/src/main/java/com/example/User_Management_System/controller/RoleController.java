package com.example.User_Management_System.controller;

import com.example.User_Management_System.dto.RoleDTO;
import com.example.User_Management_System.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping(path="/{id}")
    public RoleDTO getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    public RoleDTO createRole(@Valid @RequestBody RoleDTO roleDTO) {
        return roleService.createRole(roleDTO);
    }

    @PutMapping(path="/{id}")
    public RoleDTO updateRole(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        return roleService.updateRole(id, roleDTO);
    }

    @PostMapping(path="/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

}