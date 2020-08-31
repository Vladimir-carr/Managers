package com.managersproject.Managers.service.impl;

import com.managersproject.Managers.models.dto.WorkShiftDto;
import com.managersproject.Managers.models.dto.WorkerDto;
import com.managersproject.Managers.models.entity.WorkShift;
import com.managersproject.Managers.models.entity.Worker;
import com.managersproject.Managers.repository.WorkRepository;
import com.managersproject.Managers.repository.WorkShiftRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * <b>Сервисный класс для работы с сущностью Worker</b>
 */
@Service
@Slf4j
public class WorkerServiceImpl {

    @Autowired
    private WorkRepository workRepository;
    private WorkShiftRepository workShiftRepository;

    public void addNewWorker(WorkerDto workerDto) {
        Worker worker = workerDtoToWorkerMapping(workerDto);
        workRepository.save(worker);
        log.info("Рабочий добавлен в базу: {}", workerDto);
    }

    public void addWorkShift(WorkShiftDto workShiftDto) {
        WorkShift workShift = workShiftDtoToWorkShiftEntity(workShiftDto);
        Optional<Worker> byId = workRepository.findById(workShift.getId());
        byId.ifPresent(worker -> {
            workShift.setWorker(worker);
            workShiftRepository.save(workShift);
        });

    }

    private WorkShift workShiftDtoToWorkShiftEntity(WorkShiftDto workShiftDto) {
        WorkShift workShift = new WorkShift();
        workShift.setDate(LocalDate.parse(workShiftDto.getShiftDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        workShift.setShiftHours(workShiftDto.getShiftHours());
        return workShift;
    }


    public Worker workerDtoToWorkerMapping(WorkerDto workerDto) {
        return Worker.builder()
                .age(workerDto.getWorkerAge())
                .name(workerDto.getWorkerName()).build();
    }
}
