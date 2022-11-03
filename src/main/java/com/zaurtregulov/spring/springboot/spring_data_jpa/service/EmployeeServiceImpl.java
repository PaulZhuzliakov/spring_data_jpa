package com.zaurtregulov.spring.springboot.spring_data_jpa.service;

import com.zaurtregulov.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = new Employee();
        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        }

        return employee;
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> allByName = employeeRepository.findAllByName(name);
        return allByName;
    }
}
