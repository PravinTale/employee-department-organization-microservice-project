package com.project.departmentservice.controller;

import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor

@Tag(
        name = " REST APIs for Department resources",
        description = " REST APIs- Create Department,Update Department, Get Department, Get all Departments, Delete Department "
)
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation(
            summary = "Create Department REST API",
            description = "Used to save department in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status  201 created "

    )

    //save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDept(@RequestBody @Validated DepartmentDto departmentDto){
        DepartmentDto saveDept = departmentService.saveDept(departmentDto);
        return new ResponseEntity<>(saveDept, HttpStatus.CREATED);
    }



    @Operation(
            summary = "Get Department REST API",
            description = "Used to get department from the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status  200 created "

    )
    //get department REST API
    @GetMapping("{dept-Code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("dept-Code") String deptCode){
        DepartmentDto dept = departmentService.getDepartmentByCode(deptCode);
        return new ResponseEntity<>(dept,HttpStatus.OK);

    }
}
