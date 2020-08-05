package com.managersproject.Managers.models.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "worker_name")
    private String workerName;
    @Column(name ="worker_age")
    private int workerAge;
}
