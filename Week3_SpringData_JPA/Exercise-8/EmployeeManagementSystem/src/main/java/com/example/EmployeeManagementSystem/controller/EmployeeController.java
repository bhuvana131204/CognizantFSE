package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeProjectionClass;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees with pagination and sorting
    @GetMapping
    public ResponseEntity<Page<Employee>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        
    	 try {
    	        Page<Employee> employees = employeeService.getAllEmployees(page, size, sortBy, sortOrder);
    	        return ResponseEntity.ok(employees);
    	    } catch (Exception e) {
    	        e.printStackTrace(); // Log exception
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	    }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            // Ensure the department is correctly set
            if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
                // Perform save operation
                Employee createdEmployee = employeeService.saveEmployee(employee);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            Employee updatedEmployee = employee.get();
            updatedEmployee.setName(employeeDetails.getName());
            updatedEmployee.setEmail(employeeDetails.getEmail());
            updatedEmployee.setDepartment(employeeDetails.getDepartment());
            employeeService.saveEmployee(updatedEmployee);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // End point to get projections using interface
    @GetMapping("/projections")
    public ResponseEntity<List<EmployeeProjection>> getEmployeeProjections() {
        List<EmployeeProjection> projections = employeeService.getEmployeeProjections();
        return ResponseEntity.ok(projections);
    }

    // End point to get projections using class-based projection
    @GetMapping("/projection-classes")
    public ResponseEntity<List<EmployeeProjectionClass>> getEmployeeProjectionClasses() {
        List<EmployeeProjectionClass> projections = employeeService.getEmployeeProjectionClasses();
        return ResponseEntity.ok(projections);
    }
}
