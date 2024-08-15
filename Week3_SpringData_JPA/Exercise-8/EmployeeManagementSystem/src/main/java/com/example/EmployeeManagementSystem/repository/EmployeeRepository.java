package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeProjectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Derived query method to find an employee by email
    Optional<Employee> findByEmail(String email);
    
    // Custom query to find employees by department name
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findEmployeesByDepartment(@Param("deptName") String departmentName);
    
    // Custom native query to find employees by first name
    @Query(value = "SELECT * FROM employees e WHERE e.first_name = :firstName", nativeQuery = true)
    List<Employee> findEmployeesByFirstName(@Param("firstName") String firstName);
    
    @Query(value = "SELECT * FROM employees e WHERE e.last_name = :lastName", nativeQuery = true)
    List<Employee> findEmployeesByLastName(@Param("lastName") String lastName);
    
    Page<Employee> findByLastName(String lastName, Pageable pageable);
    Page<Employee> findByFirstName(String firstName, Pageable pageable);

    // Methods for projections
    @Query("SELECT e.id AS id, e.firstName AS firstName, e.lastName AS lastName FROM Employee e")
    List<EmployeeProjection> findAllEmployeeProjections();
    
    @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeProjectionClass(e.id, e.firstName, e.lastName) FROM Employee e")
    List<EmployeeProjectionClass> findAllEmployeeProjectionClasses();
}
