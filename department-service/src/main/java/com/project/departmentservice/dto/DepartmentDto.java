package com.project.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(
        description = "DepartmentDto model information"
)
public class DepartmentDto {

    private Long id;
    @NotEmpty(message = "Department Name should not empty or null")

    @Schema(
            description = "Department name"
    )
    private String deptName;

    @NotEmpty(message = "Department Description should not empty or null")
    @Schema(
            description = "Department Description"
    )
    private String deptDescription;


    @NotEmpty(message = "Department code should not empty or null")
    @Schema(
            description = "Department code"
    )
    private String deptCode;


}
