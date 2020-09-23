package com.managersproject.Managers.models.dto;

import com.managersproject.Managers.models.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {
    private String workerName;
    private int workerAge;
    private Department department;
}
