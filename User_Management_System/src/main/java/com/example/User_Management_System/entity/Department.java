package com.example.User_Management_System.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name", nullable = false, unique = true)
    private String departmentName;

    @OneToMany(
                    mappedBy = "department",
                    orphanRemoval = true,
                    cascade = CascadeType.ALL,
                    fetch = FetchType.LAZY
    )
    private List<User> users = new ArrayList<>();

}