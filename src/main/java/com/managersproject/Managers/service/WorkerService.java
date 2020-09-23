package com.managersproject.Managers.service;

import com.managersproject.Managers.models.dto.WorkShiftDto;
import com.managersproject.Managers.models.dto.WorkerDto;
import com.managersproject.Managers.models.entity.Worker;
import org.springframework.http.ResponseEntity;


public interface WorkerService {


    /** <b>Метод добавляет нового рабочего в БД</b>
     * @param workerDto
     */
    void addNewWorker(WorkerDto workerDto);

    void addWorkShift(WorkShiftDto workShiftDto);

    void getAmountWorkShift(WorkerDto workerDto);

}
