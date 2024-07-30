package service;


import repository.CustomerRepository;

public class CustomerService {
 private final CustomerRepository customerRepository;

 // Constructor injection
 public CustomerService(CustomerRepository customerRepository) {
     this.customerRepository = customerRepository;
 }

 public String getCustomer(String id) {
     return customerRepository.findCustomerById(id);
 }
}
