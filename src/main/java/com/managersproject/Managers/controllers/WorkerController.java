package com.managersproject.Managers.controllers;


import com.managersproject.Managers.models.dto.WorkerDto;
import com.managersproject.Managers.models.entity.Worker;
import com.managersproject.Managers.repository.WorkRepository;
import com.managersproject.Managers.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    WorkRepository workRepository;
    WorkerService workerService;


    @PostMapping("/add")
    public void addWorker(@RequestBody WorkerDto workerDto) {
        if (workerDto == null) {
            log.warn("Пришел пустой рабочий на метод addWorker");
            return;
        }
        workerService.addWorker(workerDto);
    }

    @PostMapping("/get")
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
