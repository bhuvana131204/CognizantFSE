package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeProjectionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to get all employees with pagination and sorting
    public Page<Employee> getAllEmployees(int page, int size, String sortBy, String sortOrder) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
            return employeeRepository.findAll(pageable);
        } catch (Exception e) {
            e.printStackTrace(); // Log exception
            throw e; // Re throw exception to be caught by the controller
        }
    }


    // Method to get employees by last name with pagination and sorting
    public Page<Employee> getEmployeesByLastName(String lastName, int page, int size, String sortBy, String sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
        return employeeRepository.findByLastName(lastName, pageable);
    }

    // Method to get employees by first name with pagination and sorting
    public Page<Employee> getEmployeesByFirstName(String firstName, int page, int size, String sortBy, String sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
        return employeeRepository.findByFirstName(firstName, pageable);
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

    // Method to get projections using interface
    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeRepository.findAllEmployeeProjections();
    }

    // Method to get projections using class-based projection
    public List<EmployeeProjectionClass> getEmployeeProjectionClasses() {
        return employeeRepository.findAllEmployeeProjectionClasses();
    }
}
