package com.zaurtregulov.spring.springboot.spring_data_jpa.service;

import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployee(int employeeId);

    public void saveOrUpdateEmployee(Employee employee);

    public void deleteEmployee(int employeeId);

    public List<Employee> findAllByName(String name);
}
