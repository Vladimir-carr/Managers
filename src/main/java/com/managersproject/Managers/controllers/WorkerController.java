package com.managersproject.Managers.controllers;


import com.managersproject.Managers.models.dto.WorkerDto;
import com.managersproject.Managers.models.entity.Worker;
import com.managersproject.Managers.repository.WorkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(path = "worker")
public class WorkerController {

    @Autowired
    WorkRepository workRepository;

    @PostMapping("/add")
    public void addWorker(@RequestBody WorkerDto workerDto) {
        if (workerDto == null) {
            log.warn("Пришел пустой рабочий на метод addWorker");
            return;
        }
        workRepository.save(Worker.builder()
                .workerAge(workerDto.getWorkerAge())
                .workerName(workerDto.getWorkerName()).build());

        log.info("Рабочий добавлен в базу: {}", workerDto);
    }

    @PostMapping("/get")
    List<Worker> getWorker(@RequestBody Worker worker) {
        return workRepository.findAll();
    }

    @GetMapping("/get/{id}")
    Worker getFromIdWorker(@PathVariable(name = "id") long id) {
        Optional<Worker> list = workRepository.findById(id);
        ArrayList<Worker> workers = new ArrayList<>();
        list.ifPresent(workers::add);
        return getFromIdWorker(id);
    }

}
