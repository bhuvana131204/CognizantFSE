package test;


import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import service.CustomerService;

public class TestDependencyInjection {
 public static void main(String[] args) {
     // Create repository
     CustomerRepository repository = new CustomerRepositoryImpl();

     // Inject repository into service
     CustomerService service = new CustomerService(repository);

     // Use service to find customer
     String customer = service.getCustomer("123");
     System.out.println(customer); // Output: Customer with ID: 123
 }
}
