package com.project.employeeservice.service;

import com.project.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Mark this interface as a feign client
//With base url of the service(to call)

        //This hardcoded url way
//@FeignClient(url = "http://localhost:8080,http://localhost:8082", value = "DEPARTMENT-SERVICE")


//OpenFeign library will dynamically create implementation for this interface

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    //Write the method definition of REST API which you gonna call from this current service(Employee)
    @GetMapping("api/departments/{dept-Code}")
    DepartmentDto getDepartment(@PathVariable("dept-Code") String deptCode);


}
