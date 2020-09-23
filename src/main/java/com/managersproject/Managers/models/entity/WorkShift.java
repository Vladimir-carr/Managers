package com.managersproject.Managers.models.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "WORK_SHIFT")
public class WorkShift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private int shiftHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id", foreignKey = @ForeignKey(name = "work_shift_to_worker"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Worker worker;
}
