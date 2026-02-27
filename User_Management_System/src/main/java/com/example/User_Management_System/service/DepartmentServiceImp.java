package com.example.User_Management_System.service;

import com.example.User_Management_System.dto.DepartmentDTO;
import com.example.User_Management_System.entity.Department;
import com.example.User_Management_System.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    private DepartmentDTO entityToDto(Department entity) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(entity.getId());
        departmentDTO.setDepartmentName(entity.getDepartmentName());
        return departmentDTO;
    }

    private Department dtoToEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDepartmentName());
        return department;
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        if(departmentDTO.getDepartmentName()==null || departmentDTO.getDepartmentName().isBlank()){
            throw new IllegalArgumentException("Department name cannot be empty");
        }

        Department savedDept = departmentRepository.save(dtoToEntity(departmentDTO));

        return entityToDto(savedDept);

    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Department Found With this Id"));

        if(departmentDTO.getDepartmentName()==null || departmentDTO.getDepartmentName().isBlank()){
            throw new IllegalArgumentException("Department name cannot be empty");
        }

        department.setDepartmentName(departmentDTO.getDepartmentName());
        Department updatedDepartment = departmentRepository.save(department);

        return  entityToDto(updatedDepartment);

    }

    @Override
    public void deleteDepartment(Long id) {
       Department department = departmentRepository.findById(id)
                               .orElseThrow(() -> new IllegalArgumentException("No Department Found With this Id"));
       departmentRepository.delete(department);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("No Department Found With this Id"));
        return entityToDto(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        for(Department department : departments){
            departmentDTOS.add(entityToDto(department));
        }
        return departmentDTOS;
    }
}