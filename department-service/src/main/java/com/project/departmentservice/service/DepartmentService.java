package com.project.departmentservice.service;

import com.project.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDept(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String deptCode);
}
