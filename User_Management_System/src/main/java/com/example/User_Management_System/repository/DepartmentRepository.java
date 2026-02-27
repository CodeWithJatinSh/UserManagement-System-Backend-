package com.example.User_Management_System.repository;

import com.example.User_Management_System.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}