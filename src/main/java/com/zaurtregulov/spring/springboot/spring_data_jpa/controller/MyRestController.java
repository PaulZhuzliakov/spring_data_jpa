package com.zaurtregulov.spring.springboot.spring_data_jpa.controller;

import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import com.zaurtregulov.spring.springboot.spring_data_jpa.exceptions_handling.NoSuchEmployeeException;
import com.zaurtregulov.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + employeeId  + " in database");
        }
        return employee;
    }

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.getEmployee(employeeId);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + employeeId  + " in database");
        }

        employeeService.deleteEmployee(employeeId);

        return "employee with id " + employeeId + " was deleted";
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }

}
