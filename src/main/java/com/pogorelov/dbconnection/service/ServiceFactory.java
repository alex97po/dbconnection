package com.pogorelov.dbconnection.service;

import com.pogorelov.dbconnection.repository.DepartmentDAO;
import com.pogorelov.dbconnection.repository.EmployeeDAO;

public class ServiceFactory {

    public DepartmentService getDepartmentService() {
        return new DepartmentService(new DepartmentDAO());
    }

    public EmployeeService getEmployeeService() {
        return new EmployeeService(new EmployeeDAO());
    }
}
