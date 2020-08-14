package com.managersproject.Managers.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String departmentName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private Set<Worker> workerList;

}
