package com.pogorelov.dbconnection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
