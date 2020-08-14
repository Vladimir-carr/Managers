package com.managersproject.Managers.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "WORKER")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int age;

    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = worker_to_department))
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worker")
    private Set<WorkShift> workShiftList;
}
