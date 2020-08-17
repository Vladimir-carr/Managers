package com.managersproject.Managers.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "WORK_SHIFT")
public class WorkShift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private LocalDate date;
    private int shiftHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id", foreignKey = @ForeignKey(name = "work_shift_to_worker"))
    private Worker worker;
}
