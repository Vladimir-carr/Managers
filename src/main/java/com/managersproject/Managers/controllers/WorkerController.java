package com.managersproject.Managers.controllers;


import com.managersproject.Managers.models.dto.WorkShiftDto;
import com.managersproject.Managers.models.dto.WorkerDto;
import com.managersproject.Managers.repository.WorkRepository;
import com.managersproject.Managers.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "worker")
@RequiredArgsConstructor
public class WorkerController {

    @Autowired
    private WorkerService workerService;


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

    /*@PostMapping("/get")
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
    }*/
}
