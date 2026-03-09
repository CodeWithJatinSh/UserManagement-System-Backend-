package com.example.User_Management_System.controller;

import com.example.User_Management_System.dto.RoleDTO;
import com.example.User_Management_System.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/role")
public class RoleController {

   /*============================= INJECTING ======================================*/
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /*============================ GET ALL THE ROLES (GET) ============================================*/
    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    /*============================ GET ROLE BY ID (GET) ============================================*/
    @GetMapping(path="/{id}")
    public RoleDTO getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    /*============================ CREATE A ROLE (POST) ============================================*/
    @PostMapping
    public RoleDTO createRole(@Valid @RequestBody RoleDTO roleDTO) {
        return roleService.createRole(roleDTO);
    }

    /*============================ UPDATE A ROLE (PUT) ============================================*/
    @PutMapping(path="/{id}")
    public RoleDTO updateRole(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        return roleService.updateRole(id, roleDTO);
    }

    /*============================ DELETE A ROLE (POST) ============================================*/
    /* We use Post method instead of Delete because we are making changes in DB data that's why */
    @PostMapping(path="/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

}