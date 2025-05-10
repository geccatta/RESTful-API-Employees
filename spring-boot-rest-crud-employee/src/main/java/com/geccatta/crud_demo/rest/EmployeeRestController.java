package com.geccatta.crud_demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.geccatta.crud_demo.entity.Employee;
import com.geccatta.crud_demo.errorResponse.exceptions.EmployeeDoesntExist;
import com.geccatta.crud_demo.errorResponse.exceptions.EmployeeIDModificationException;
import com.geccatta.crud_demo.errorResponse.exceptions.EmployeeNotFound;
import com.geccatta.crud_demo.service.Employee.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService es,
                                  ObjectMapper om) {
        employeeService = es;
        objectMapper = om;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployee(@PathVariable Integer empId){
        Employee employee = employeeService.getEmployee(empId);
        if(employee == null){
            throw new EmployeeNotFound("Employee with id=" +empId+ " not found!");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee emp = employeeService.addEmployee(employee);

        return emp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable Integer empId){
        Employee employee = employeeService.getEmployee(empId);
        if(employee == null){
            throw new EmployeeDoesntExist("Employee with ID="+empId+" doesn't exist!");
        }else{
            employeeService.deleteEmployee(empId);
        }
        return "Deleting employee with id=" +empId;
    }

    @PatchMapping("/employees/{empId}")
    public Employee patchEmployee(@PathVariable Integer empId,
                                  @RequestBody Map<String, Object> patchPayload)
    {
        Employee employee = employeeService.getEmployee(empId);
        if(patchPayload.containsKey("id")){
            throw new EmployeeIDModificationException("Not allowed to change Primary key!");
        }

        //patch the employee
        Employee patchedEmployee = apply(patchPayload, employee);
        //then save the patched employee to the db
        Employee savedEmployee = employeeService.addEmployee(patchedEmployee);

        return savedEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee employee) {
        //Convert employee obj to JSON obj node
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        //Convert patchPayload map to JSON obj node
        ObjectNode patchPayloadNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        //merge these 2 obj nodes
        employeeNode.setAll(patchPayloadNode);

        //Convert back the employeeNode back to employee obj
        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
