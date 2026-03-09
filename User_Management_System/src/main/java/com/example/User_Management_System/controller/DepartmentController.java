package com.example.User_Management_System.controller;


import com.example.User_Management_System.dto.DepartmentDTO;
import com.example.User_Management_System.entity.Department;
import com.example.User_Management_System.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/department")
public class DepartmentController{

    /*============================ INJECTING ============================================*/
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /*============================ GET ALL THE DEPARTMENTS (GET) ============================================*/
    @GetMapping
    public List<DepartmentDTO> getDepartments(){
        return departmentService.getAllDepartments();
    }

    /*============================ GET DEPARTMENT BY ID (GET) ============================================*/
    @GetMapping(path="/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    /*============================ CREATE DEPARTMENT (POST) ============================================*/
    @PostMapping
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.createDepartment(departmentDTO);
    }

    /*============================ DELETE DEPARTMENT (POST) ============================================*/
    @PostMapping(path="/delete/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

    /*============================ UPDATE DEPARTMENT (PUT) ============================================*/
    @PutMapping(path="/{id}")
    public DepartmentDTO updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO){
        return departmentService.updateDepartment(id, departmentDTO);
    }


}