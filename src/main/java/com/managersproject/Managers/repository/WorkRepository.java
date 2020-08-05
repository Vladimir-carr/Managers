package com.managersproject.Managers.repository;

import com.managersproject.Managers.models.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Worker, Long> {

    List<Worker> findAllByWorkerNameAndWorkerAge(String workerName, int workerAge);
}
