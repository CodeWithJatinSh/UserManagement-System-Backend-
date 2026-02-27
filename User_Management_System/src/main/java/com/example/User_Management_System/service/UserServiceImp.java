package com.example.User_Management_System.service;

import com.example.User_Management_System.dto.UserRequestDTO;
import com.example.User_Management_System.dto.UserResponseDTO;
import com.example.User_Management_System.entity.Department;
import com.example.User_Management_System.entity.Role;
import com.example.User_Management_System.entity.User;
import com.example.User_Management_System.mapper.UserMapper;
import com.example.User_Management_System.repository.DepartmentRepository;
import com.example.User_Management_System.repository.RoleRepository;
import com.example.User_Management_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp  implements UserService {

    /*=================================DEPENDENCY INJECTION===========================*/
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;

    /*===================================CREATE USER========================================*/
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);

        //Manually Setting Department
        Department department = departmentRepository.findById(userRequestDTO.getDepartmentId())
                .orElseThrow(()->new RuntimeException("Department Not Found"));
        user.setDepartment(department);

        //Manually Setting Roles
        Set<Role> roles = new HashSet<>(roleRepository.findAllById(userRequestDTO.getRoleIds()));
        user.setRoles(roles);

        User savedUser = userRepository.save(user);

        return userMapper.toResponseDTO(savedUser);

    }

    /*==============================UPDATE USER====================================================*/
    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User exist = userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));

        //Setting Fields
        exist.setFullName(userRequestDTO.getFullName());
        exist.setEmail(userRequestDTO.getEmail());
        exist.setMobile(userRequestDTO.getMobile());
        exist.setAddress(userRequestDTO.getAddress());

        //Manually Setting Department
        Department department = departmentRepository.findById(userRequestDTO.getDepartmentId())
                .orElseThrow(()->new RuntimeException("Department Not Found"));
        exist.setDepartment(department);

        //Manually Setting Roles
        Set<Role> roles = new HashSet<>(roleRepository.findAllById(userRequestDTO.getRoleIds()));
        exist.setRoles(roles);


        User savedUser=userRepository.save(exist);
        return userMapper.toResponseDTO(savedUser);
    }

    /*==================================DELETE USER================================================*/
    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
        userRepository.deleteById(id);
    }

    /*=================================== GET USERS BY ID =================================================*/
    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
        return userMapper.toResponseDTO(user);
    }

    /*=================================== GET ALL USERS =================================================*/
    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toResponseDTOList(users);
    }
}