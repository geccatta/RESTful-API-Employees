package com.geccatta.crud_demo.service;

import com.geccatta.crud_demo.dao.EmployeeDAO;
import com.geccatta.crud_demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployee(Integer empId) {
        return employeeDAO.getEmployee(empId);
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer empId) {
        employeeDAO.deleteEmployee(empId);
    }


}
