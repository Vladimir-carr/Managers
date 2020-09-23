package com.managersproject.Managers.repository;

import com.managersproject.Managers.models.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkRepository extends JpaRepository<Worker, Long> {


}
