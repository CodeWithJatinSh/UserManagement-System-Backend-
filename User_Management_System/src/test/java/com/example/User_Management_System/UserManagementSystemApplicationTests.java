package com.example.User_Management_System;

import com.example.User_Management_System.repository.RoleRepository;
import com.example.User_Management_System.repository.UserRepository;
import com.example.User_Management_System.service.RoleService;
import com.example.User_Management_System.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserManagementSystemApplicationTests {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Test
	void contextLoads() {
	}

}
