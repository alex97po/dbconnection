package com.pogorelov.dbconnection.service;

import com.pogorelov.dbconnection.domain.Department;
import com.pogorelov.dbconnection.repository.DepartmentDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentDAO departmentDAO;

    public List<Department> findAllDepartments() {
        return departmentDAO.findAllDepartments();
    }

    public Department findDepartmentById(Long id) {
        return departmentDAO.findDepartmentById(id).orElseThrow(() -> { throw new RuntimeException("Depatment not found by id" + id); });

    }
}
