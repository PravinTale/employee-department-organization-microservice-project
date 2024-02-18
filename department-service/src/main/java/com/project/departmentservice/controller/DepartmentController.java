package com.project.departmentservice.controller;

import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDept(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDept = departmentService.saveDept(departmentDto);
        return new ResponseEntity<>(saveDept, HttpStatus.CREATED);
    }

    //get department REST API
    @GetMapping("{dept-Code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("dept-Code") String deptCode){
        DepartmentDto dept = departmentService.getDepartmentByCode(deptCode);
        return new ResponseEntity<>(dept,HttpStatus.OK);

    }
}
