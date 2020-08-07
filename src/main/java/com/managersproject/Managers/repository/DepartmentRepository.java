package com.managersproject.Managers.repository;

import com.managersproject.Managers.models.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Long> {


    List<Departments> findAllByDepartmentName(String departmentName);
}
