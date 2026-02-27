package com.example.User_Management_System.dto;

import java.util.HashSet;
import java.util.Set;

import com.example.User_Management_System.entity.Department;
import com.example.User_Management_System.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    private Long id;

    @NotBlank(message = "Name Should Not be Blank")
    private String fullName;

    private String address;

    @Size(min=10,max=10,message = "Invalid Mobile Number")
    private String mobile;        // String, not int

    @NotBlank
    private String email;

    private Set<Long> roleIds = new HashSet<>();

    private Long departmentId;
}