package com.example.User_Management_System.repository;

import com.example.User_Management_System.entity.Role;
import com.example.User_Management_System.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Page<User> findByDepartmentId(Long departmentId, Pageable pageable);

    Page<User> findByRoles(Set<Role> roles, Pageable pageable);
}