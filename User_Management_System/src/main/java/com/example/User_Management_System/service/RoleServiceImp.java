package com.example.User_Management_System.service;

import com.example.User_Management_System.dto.RoleDTO;
import com.example.User_Management_System.entity.Role;
import com.example.User_Management_System.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /*===================================== MAP ENTITY TO DTO ===============================*/
    private RoleDTO roleToRoleDto(Role role){
        RoleDTO savedRoleDTO = new RoleDTO();
        savedRoleDTO.setId(role.getId());
        savedRoleDTO.setRoleName(role.getRoleName());
        return savedRoleDTO;
    }

    /*============================= CREATE ROLE =========================================*/
    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        if(roleDTO.getRoleName() == null || roleDTO.getRoleName().isBlank()){
            throw new  IllegalArgumentException("Role Name is Null");
        }
        Role role = new Role();
        role.setRoleName(roleDTO.getRoleName());

        Role savedRole = roleRepository.save(role);
        return roleToRoleDto(savedRole);

    }

    /*=============================== UPDATE ROLE ===========================================*/
    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {

        if(roleDTO.getRoleName() == null || roleDTO.getRoleName().isBlank()){
            throw new  IllegalArgumentException("Role Name is Null");
        }

        Role role = roleRepository.findById(id)
                    .orElseThrow(() -> new  IllegalArgumentException("Role Not Found"));
        role.setRoleName(roleDTO.getRoleName());

        Role savedRole = roleRepository.save(role);

        return roleToRoleDto(savedRole);
    }

    /*================================ DELETE ROLE =================================*/
    @Override
    public void deleteRole(Long id) {
      Role role =  roleRepository.findById(id)
                   .orElseThrow(() -> new  IllegalArgumentException("Role Not Found"));
      roleRepository.delete(role);
    }

    /*================================ GET ROLE BY ID =================================*/
    @Override
    public RoleDTO getRoleById(Long id) {
       Role role =  roleRepository.findById(id)
                   .orElseThrow(() -> new  IllegalArgumentException("Role Not Found"));

       return roleToRoleDto(role);
    }

    /*================================ GET LIST OF ALL ROLES =================================*/
    @Override
    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for (Role role : roles) {
          roleDTOS.add(roleToRoleDto(role));
        }
        return roleDTOS;
    }
}