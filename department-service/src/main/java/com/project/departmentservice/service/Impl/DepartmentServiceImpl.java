package com.project.departmentservice.service.Impl;

import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.entity.Department;
import com.project.departmentservice.exception.ResourceNotFoundException;
import com.project.departmentservice.mapper.AutoDepartmentMapper;
import com.project.departmentservice.repository.DepartmentRepository;
import com.project.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
//Instead of creating constructor manually we are using lombok annotation
//This constructor used for constructor based dependency injection
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepo;
    @Override
    public DepartmentDto saveDept(DepartmentDto departmentDto) {

        //Converting dto to jpa entity
        Department department = AutoDepartmentMapper.MAPPER.mapTODepartment(departmentDto);

        //saving jpa entity to db
        Department savedDept = departmentRepo.save(department);

        //Jpa to Dto
        DepartmentDto savedDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDept);

        return savedDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptCode) {
        Department department = departmentRepo.findByDeptCode(deptCode).orElseThrow(
                ()-> new ResourceNotFoundException("Department","deptCode",deptCode)
        );
        //convert Jpa to dto
        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
