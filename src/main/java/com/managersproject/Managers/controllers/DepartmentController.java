package com.managersproject.Managers.controllers;

import com.managersproject.Managers.models.dto.DepartmentDto;
import com.managersproject.Managers.models.entity.Department;
import com.managersproject.Managers.repository.DepartmentRepository;
import com.managersproject.Managers.service.impl.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(path = "departments")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public void addDepartment(@RequestBody DepartmentDto departmentDto) {
        if (departmentDto == null) {
            log.warn("Пришел пустой департамент в addDepartment");
            return;
        }
        departmentService.addDepartment(departmentDto);
    }

    @PostMapping("/get")
    List<Department> getDepartments(@RequestBody Department department) {
        return departmentRepository.findAll();
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Department> getFromIfDepartment(@PathVariable(name = "id") long id) {
        Optional<Department> byId = departmentRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
