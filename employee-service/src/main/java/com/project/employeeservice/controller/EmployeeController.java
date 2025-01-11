package com.project.employeeservice.controller;

import com.project.employeeservice.dto.ApiResponseDto;
import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor

@Tag(
        name = "Employee Service REST APIS",
        description = "Spring Boot REST Controller for Employee Service"
)
public class EmployeeController {

    public EmployeeService employeeService;

    @Operation(
            summary = "Create Employee REST API",
            description = "Used to save employee in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status  201 created "

    )
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Validated EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Employee REST API",
            description = "Used to save Employee in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status  201 created "

    )
    @GetMapping("{emp-id}")
    public  ResponseEntity<ApiResponseDto>  getEmployee(@PathVariable("emp-id") Long empId){
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
