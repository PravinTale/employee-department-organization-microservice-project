package com.project.employeeservice.controller;

import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

    public EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("{emp-id}")
    public  ResponseEntity<EmployeeDto>  getEmployee(@PathVariable("emp-id") Long empId){
        EmployeeDto employee = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

}
