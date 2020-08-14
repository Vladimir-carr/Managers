package com.managersproject.Managers.repository;

import com.managersproject.Managers.models.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    List<Department> findAllByDepartmentName(String departmentName);
}
