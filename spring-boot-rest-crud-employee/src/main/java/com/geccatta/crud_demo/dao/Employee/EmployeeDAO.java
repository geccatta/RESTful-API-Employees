package com.geccatta.crud_demo.dao.Employee;

import com.geccatta.crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee getEmployee(Integer empId);
    Employee addEmployee(Employee employee);
    void deleteEmployee(Integer empId);
}
