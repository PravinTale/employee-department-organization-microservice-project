package com.project.employeeservice.service.impl;

import com.project.employeeservice.dto.ApiResponseDto;
import com.project.employeeservice.dto.DepartmentDto;
import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.entity.Employee;
import com.project.employeeservice.exception.ResourceNotFoundException;
import com.project.employeeservice.mapper.AutoEmployeeMapper;
import com.project.employeeservice.mapper.AutoEmployeeMapperImpl;
import com.project.employeeservice.repository.EmployeeRepository;
import com.project.employeeservice.service.APIClient;
import com.project.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;
    //private RestTemplate restTemplate;

    //private WebClient webClient;

    private APIClient apiClient;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //EmployeeDto to Employee using MapStruct
        Employee employee = AutoEmployeeMapperImpl.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmp = employeeRepo.save(employee);

        EmployeeDto saveEmpDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        return saveEmpDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long empId) {
        Employee employee = employeeRepo.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","id",empId)
        );
        //getEntity() takes 2-parameter first URI of REST API and response class type , returns ResponseEntity
        //Contains DepartmentDto Object

        /*
            //This piece of code is written w.r.t RestTemplate

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDeptCode(),

                DepartmentDto.class);

        //returns body(i.e JSON)
        DepartmentDto departmentDto = responseEntity.getBody();

         */


        /*
        // Using WebClient

        DepartmentDto departmentDto = webClient.get()
                                                .uri("http://localhost:8080/api/departments/" + employee.getDeptCode())
                                                .retrieve()
                                                .bodyToMono(DepartmentDto.class)
                                                .block();

         */

        //Using feignClient

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDeptCode());

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        //Inorder to send 2 objects(i.e employeeDto and departmentDto)as a response, we are using ApiResponseDto
        ApiResponseDto apiResponseDto = new ApiResponseDto(
                employeeDto,
                departmentDto
        );
        return apiResponseDto;

    }
}