package com.pogorelov.dbconnection.repository;

import com.pogorelov.dbconnection.domain.Department;

import javax.persistence.EntityManager;
import java.util.Optional;

public class DepartmentDAO extends GenericDAO<Department, Long> {

    public Optional<Department> getDepartmentByName(String name) {
        EntityManager em = getEntityManager();
        Department departmentFromDB = (Department) em.createQuery("SELECT department FROM Department department where department.name = ?1")
                .setParameter(1, name).getSingleResult();
        em.close();
        return Optional.ofNullable(departmentFromDB);
    }

    @Override
    public Class<Department> getEntityClass() {
        return Department.class;
    }
}
