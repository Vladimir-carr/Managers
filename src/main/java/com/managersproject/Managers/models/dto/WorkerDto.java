package com.managersproject.Managers.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerDto {
    private String workerName;
    private int workerAge;
}
