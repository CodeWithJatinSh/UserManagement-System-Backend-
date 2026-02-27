package com.example.User_Management_System.repository;

import com.example.User_Management_System.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

   List<Role> findByRoleName(@Param("roleName") String roleName);
}