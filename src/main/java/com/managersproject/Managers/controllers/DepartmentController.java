package com.managersproject.Managers.controllers;

import com.managersproject.Managers.models.dto.DepartmentDto;
import com.managersproject.Managers.models.entity.Department;
import com.managersproject.Managers.repository.DepartmentRepository;
import com.managersproject.Managers.service.impl.DepartmentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "departments")
public class DepartmentController {

    DepartmentRepository departmentRepository;
    DepartmentServiceImpl departmentService;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository, DepartmentServiceImpl departmentService) {
        this.departmentRepository = departmentRepository;
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public void addDepartment(@RequestBody DepartmentDto departmentDto) {
        if (departmentDto == null) {
            log.warn("Пришел пустой департамент в addDepartment");
            return;
        }
        departmentService.addDepartment(departmentDto);
    }

    @GetMapping("/get")
    List<Department> getDepartments(@RequestBody Department department) {
        return departmentRepository.findAll();
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Department> getFromIdDepartment(@PathVariable(name = "id") long id) {
        Optional<Department> byId = departmentRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
