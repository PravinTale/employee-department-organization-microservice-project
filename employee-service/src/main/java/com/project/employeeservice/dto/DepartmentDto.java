package com.project.employeeservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @NotEmpty(message = "Department Name should not empty or null")
    private String deptName;
    @NotEmpty(message = "Department Description should not empty or null")
    private String deptDescription;
    @NotEmpty(message = "Department code should not empty or null")
    private String deptCode;

}
