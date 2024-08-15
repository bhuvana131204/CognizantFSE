package com.example.EmployeeManagementSystem.repository;
import com.example.EmployeeManagementSystem.Department;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Derived query method to find a department by name
    Department findByName(String name);
}
