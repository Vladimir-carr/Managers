package com.managersproject.Managers.service;

import com.managersproject.Managers.models.entity.Departments;
import com.managersproject.Managers.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.managersproject.Managers.models.dto.DepartmentDto;

@Slf4j
@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public void addDepartment(DepartmentDto departmentDto) {
        Departments departments = departmentDtoToDepartmentsMapping(departmentDto);
        departmentRepository.save(departments);
        log.info("Департамент добавлен в базу: {}", departmentDto);
    }

    public Departments departmentDtoToDepartmentsMapping(DepartmentDto departmentDto) {
        return Departments.builder()
                .departmentName(departmentDto.getDepartmentDtoName())
                .build();
    }
}
