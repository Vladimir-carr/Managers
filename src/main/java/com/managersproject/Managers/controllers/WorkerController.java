package com.managersproject.Managers.controllers;


import com.managersproject.Managers.models.dto.WorkShiftDto;
import com.managersproject.Managers.models.dto.WorkerDto;
import com.managersproject.Managers.models.entity.Department;
import com.managersproject.Managers.models.entity.Worker;
import com.managersproject.Managers.repository.DepartmentRepository;
import com.managersproject.Managers.repository.WorkRepository;
import com.managersproject.Managers.service.WorkerService;
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
@RequestMapping(path = "worker")
@RequiredArgsConstructor
public class WorkerController {

    private WorkerService workerService;
    private WorkRepository workRepository;

    @Autowired
    public WorkerController(WorkerService workerService, WorkRepository workRepository) {
        this.workerService = workerService;
        this.workRepository = workRepository;
    }

    @PostMapping("/addWorker")
    public void addWorker(@RequestBody WorkerDto workerDto) {
        if (workerDto == null) {
            log.warn("Пришел пустой рабочий на метод addWorker");
            return;
        }
        workerService.addNewWorker(workerDto);
    }

    @PostMapping("/addWorkShift")
    public void addWorkShift(@RequestBody WorkShiftDto workShiftDto) {
        if (workShiftDto == null) {
            log.warn("Пришла пустая рабочая смена на метод addWorkShift");
        }
        workerService.addWorkShift(workShiftDto);
    }

    @GetMapping("/getAmountWorkShift")
    public void getAmountWorkShift(@RequestBody WorkerDto workerDto) {
        if (workerDto == null) {
            log.warn("Пришел пустой рабочий");
        }
        workerService.getAmountWorkShift(workerDto);
    }


    @GetMapping("/get")
    List<Worker> getWorker(@RequestBody Worker worker) {
        return workRepository.findAll();
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Worker> getFromIdWorker(@PathVariable(name = "id") long id) {
        Optional<Worker> byId = workRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
