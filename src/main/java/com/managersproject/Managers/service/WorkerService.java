package com.managersproject.Managers.service;

import com.managersproject.Managers.models.dto.WorkerDto;
import com.managersproject.Managers.models.entity.Worker;
import com.managersproject.Managers.repository.WorkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WorkerService {

    @Autowired
    WorkRepository workRepository;

    public void addWorker(WorkerDto workerDto) {
        Worker worker = workerDtoToWorkerMapping(workerDto);
        workRepository.save(worker);
        log.info("Рабочий добавлен в базу: {}", workerDto);
    }


    public Worker workerDtoToWorkerMapping(WorkerDto workerDto) {
        return Worker.builder()
                .age(workerDto.getAge())
                .name(workerDto.getName()).build();
    }
}
