package com.managersproject.Managers.repository;

import com.managersproject.Managers.models.entity.WorkShift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkShiftRepository extends CrudRepository<WorkShift, Long> {
}
