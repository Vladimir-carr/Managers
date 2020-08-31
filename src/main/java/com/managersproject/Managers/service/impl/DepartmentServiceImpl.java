package com.managersproject.Managers.service.impl;

import com.managersproject.Managers.models.entity.Department;
import com.managersproject.Managers.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.managersproject.Managers.models.dto.DepartmentDto;

@Slf4j
@Service
public class DepartmentServiceImpl {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void addDepartment(DepartmentDto departmentDto) {
        Department department = departmentDtoToDepartmentsMapping(departmentDto);
        departmentRepository.save(department);
        log.info("Департамент добавлен в базу: {}", departmentDto);
    }

    public Department departmentDtoToDepartmentsMapping(DepartmentDto departmentDto) {
        return Department.builder()
                .departmentName(departmentDto.getDepartmentDtoName())
                .build();
    }
}
