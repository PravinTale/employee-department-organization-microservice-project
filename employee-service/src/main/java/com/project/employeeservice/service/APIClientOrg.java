package com.project.employeeservice.service;

import com.project.employeeservice.dto.DepartmentDto;
import com.project.employeeservice.dto.OrganisationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANISATION-SERVICE")
public interface APIClientOrg {
    //Write the method definition of REST API which you gonna call from this current service(Employee)
    @GetMapping("api/organisation/{org-Code}")
    OrganisationDto getOrganisation(@PathVariable("org-Code") String code);
}

