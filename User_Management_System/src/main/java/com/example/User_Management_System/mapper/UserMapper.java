package com.example.User_Management_System.mapper;

import com.example.User_Management_System.dto.DepartmentDTO;
import com.example.User_Management_System.dto.RoleDTO;
import com.example.User_Management_System.dto.UserRequestDTO;
import com.example.User_Management_System.dto.UserResponseDTO;
import com.example.User_Management_System.entity.Department;
import com.example.User_Management_System.entity.Role;
import com.example.User_Management_System.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // User Entity → UserResponseDTO
    @Mapping(source = "department", target = "department")
    @Mapping(source = "roles", target = "roles")
    UserResponseDTO toResponseDTO(User user);

    // UserRequestDTO → User Entity
    @Mapping(target = "department", ignore = true)  // handled in service
    @Mapping(target = "roles", ignore = true)        // handled in service
    User toEntity(UserRequestDTO requestDTO);

    // List of Users → List of UserResponseDTOs
    List<UserResponseDTO> toResponseDTOList(List<User> users);

    // Role Entity → RoleDTO
    RoleDTO toRoleDTO(Role role);

    // Department Entity → DepartmentDTO
    DepartmentDTO toDepartmentDTO(Department department);

    // Set of Roles → Set of RoleDTOs
    Set<RoleDTO> toRoleDTOSet(Set<Role> roles);
}
