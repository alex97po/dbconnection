package com.pogorelov.dbconnection.service;

import com.pogorelov.dbconnection.domain.Department;
import com.pogorelov.dbconnection.repository.DepartmentDAO;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentDAO departmentDAO;

    public void createDepartment(Department department) {
        departmentDAO.save(department);
    }

    public void updateDepartment(Department department) {
        departmentDAO.update(department, department.getId());
    }

    public void deleteDepartment(Long id) {
        departmentDAO.deleteDepartment(id);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    public Department findDepartmentById(Long id) {
        return departmentDAO.findById(id).orElseThrow(() -> { throw new EntityNotFoundException("Department not found by id: " + id); });
    }

    public Department findDepartmentByName(String name) {
        return departmentDAO.getDepartmentByName(name).orElseThrow(() -> {throw new EntityNotFoundException("Department not found by name: " + name);});
    }
}
