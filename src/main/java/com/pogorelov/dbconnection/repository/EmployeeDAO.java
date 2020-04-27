package com.pogorelov.dbconnection.repository;

import com.pogorelov.dbconnection.domain.Employee;

public class EmployeeDAO extends GenericDAO<Employee, Long> {

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
