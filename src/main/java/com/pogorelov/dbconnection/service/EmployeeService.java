package com.pogorelov.dbconnection.service;

import com.pogorelov.dbconnection.domain.Employee;
import com.pogorelov.dbconnection.repository.EmployeeDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }
}
