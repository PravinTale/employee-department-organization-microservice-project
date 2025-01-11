package com.project.employeeservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fname", nullable = false)
    private String firstName;
    @Column(name = "lname", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @Column(name = "deptCode", nullable = false)
    private String deptCode;

    @Column(name = "orgCode", nullable = false)
    private String orgCode;

}
