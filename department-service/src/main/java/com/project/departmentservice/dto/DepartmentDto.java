package com.project.departmentservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
