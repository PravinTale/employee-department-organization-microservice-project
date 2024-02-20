package com.project.employeeservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.boot.archive.scan.internal.ScanResultImpl;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "Employee first name can not be empty or null")
    private String firstName;

    @NotEmpty(message = "Employee last name can not be empty or null")
    private String lastName;

    @NotEmpty(message = "Employee email can not be empty or null")
    @Email(message = "Employee email should be valid")
    private String email;


    private String deptCode;
}
