package com.project.employeeservice.service.impl;

import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.entity.Employee;
import com.project.employeeservice.exception.ResourceNotFoundException;
import com.project.employeeservice.mapper.AutoEmployeeMapper;
import com.project.employeeservice.repository.EmployeeRepository;
import com.project.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeRepository employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //EmployeeDto to Employee using MapStruct
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmp = employeeRepo.save(employee);

        EmployeeDto saveEmpDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        return saveEmpDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long empId) {
        Employee employee = employeeRepo.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","id",empId)
        );

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        return employeeDto;

    }
}