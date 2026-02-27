package com.example.User_Management_System.controller;


import com.example.User_Management_System.dto.DepartmentDTO;
import com.example.User_Management_System.entity.Department;
import com.example.User_Management_System.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/department")
public class DepartmentController{

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentDTO> getDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping(path="/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.createDepartment(departmentDTO);
    }

    @PostMapping(path="/delete/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

    @PutMapping(path="/{id}")
    public DepartmentDTO updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO){
        return departmentService.updateDepartment(id, departmentDTO);
    }


}