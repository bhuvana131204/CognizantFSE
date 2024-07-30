package employee;

public class Program {
	public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(10);
        em.addEmployee(new Employee("1", "Bhuvana", "Data Scientist", 100000));
        em.addEmployee(new Employee("2", "Sravya", "Developer", 200000));
        em.addEmployee(new Employee("3", "Radha", "Designer", 500000));

    
        System.out.println("Listing Employees:");
        em.traverseEmployees();

  
        System.out.println("\nSearching for Employee with ID 2:");
        Employee emp = em.searchEmployee("2");
        System.out.println(emp != null ? emp : "Employee not found");

  
        System.out.println("\nDeleting Employee with ID 1:");
        em.deleteEmployee("1");

  
        System.out.println("\nAll Employees after deletion:");
        em.traverseEmployees();
    }
}
