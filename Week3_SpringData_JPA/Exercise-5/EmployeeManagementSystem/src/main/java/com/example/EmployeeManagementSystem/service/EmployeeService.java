package com.example.EmployeeManagementSystem.service;
import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    public void printEmployeesByLastName(String lastName) {
        List<Employee> employees = employeeRepository.findEmployeesByLastName(lastName);
        employees.forEach(System.out::println);
    }
    public void printEmployeesByfirstName(String firstName) {
        List<Employee> employees = employeeRepository.findEmployeesByFirstName(firstName);
        employees.forEach(System.out::println);
    }
}
