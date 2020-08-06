package com.managersproject.Managers.controllers;

import com.managersproject.Managers.models.dto.DepartmentDto;
import com.managersproject.Managers.models.entity.Departments;
import com.managersproject.Managers.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "departments")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @PostMapping("/add")
    public void addDepartment(@RequestBody DepartmentDto departmentDto) {
        if (departmentDto == null) {
            log.warn("Пришел пустой департамент в addDepartment");
            return;
        }
        departmentRepository.save(Departments.builder()
                .departmentName(departmentDto.getDepartmentDtoName())
                .build());
        log.info("Департамент добавлен в базу: {}", departmentDto);
    }
    @PostMapping("/get")
    List<Departments> getDepartments(@RequestBody Departments departments) {
        return departmentRepository.findAll();
    }

}
