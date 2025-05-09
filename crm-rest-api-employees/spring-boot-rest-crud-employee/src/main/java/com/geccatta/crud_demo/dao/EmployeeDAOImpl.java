package com.geccatta.crud_demo.dao;

import com.geccatta.crud_demo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        entityManager = em;
    }

    @Override
    public List<Employee> findAll() {
        var getAllEmployees = entityManager.createQuery
                ("FROM Employee", Employee.class);
        List<Employee> employees = getAllEmployees.getResultList();

        return employees;
    }

    @Override
    public Employee getEmployee(Integer empId){
        return entityManager.find(Employee.class, empId);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee emp = entityManager.merge(employee);
        return emp;
    }

    @Override
    public void deleteEmployee(Integer empId) {
        Employee employee = getEmployee(empId);
        if (employee != null){
            entityManager.remove(employee);
        }
    }


}
