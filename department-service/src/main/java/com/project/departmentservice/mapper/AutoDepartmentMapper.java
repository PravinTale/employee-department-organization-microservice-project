package com.project.departmentservice.mapper;

import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {
    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);
    Department mapTODepartment(DepartmentDto departmentDto);
}
