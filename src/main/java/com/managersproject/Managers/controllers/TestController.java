package com.managersproject.Managers.controllers;


import com.managersproject.Managers.models.Dto.WorkerDto;
import com.managersproject.Managers.models.entity.Worker;
import com.managersproject.Managers.repository.WorkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
//@RequestMapping(path = "worker")
public class TestController {

    @Autowired
    WorkRepository workRepository;

    static List<Worker> listWorker = new ArrayList<>();

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
    List<Worker> showWorker(@RequestBody Worker worker) {
        return workRepository.findAll();
    }

    @GetMapping("/showme/{id}")
    Worker showFromIdWorker(@PathVariable(name = "id") Long id, @RequestParam(name = "id") int idNum) {
        return listWorker.get(idNum);
    }

    public static void printWorker() {
        for (Worker worker : TestController.listWorker) {
            System.out.println(worker.toString());
        }
    }
}
