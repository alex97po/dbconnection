package com.pogorelov.dbconnection.repository;

import com.pogorelov.dbconnection.domain.Department;

import java.util.List;
import java.util.Optional;

public class DepartmentDAO {

    private static final String GET_ALL = "Select * From department";



    public List<Department> findAllDepartments() {

    }

    public Optional<Department> findDepartmentById(Long id) {
        Optional.ofNullable()
    }
}
