package com.example.EmployeeManagementSystem.repository;
import com.example.EmployeeManagementSystem.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Derived query method to find an employee by email
    Optional<Employee> findByEmail(String email);
    
   /* List<Employee> findByLastName(String lastName);
    
    List<Employee> findByDepartmentName(String departmentName);

    Employee findByLastNameAndFirstName(String lastName, String firstName);
 
    Long countByDepartmentName(String departmentName);
 
    void deleteByFirstName(String firstName);@Query("SELECT e FROM Employee e WHERE e.lastName = :lastName")
    List<Employee> findEmployeesByLastName(@Param("lastName") String lastName);  */
    
    // Custom query to find employees by department name
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findEmployeesByDepartment(@Param("deptName") String departmentName);
    
    // Custom native query to find employees by first name
    @Query(value = "SELECT * FROM Employee e WHERE e.first_name = :firstName", nativeQuery = true)
    List<Employee> findEmployeesByFirstName(@Param("firstName") String firstName);
    
    @Query(value = "SELECT * FROM Employee e WHERE e.last_name = :lastName", nativeQuery = true)
    List<Employee> findEmployeesByLastName(@Param("lastName") String lastName);
    Page<Employee> findByLastName(String lastName, Pageable pageable);
    Page<Employee> findByFirstName(String firstName, Pageable pageable);
    

}

