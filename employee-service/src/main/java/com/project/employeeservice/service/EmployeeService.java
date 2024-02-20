package com.project.employeeservice.service;

import com.project.employeeservice.dto.ApiResponseDto;
import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.entity.Employee;


public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long Id);


}
