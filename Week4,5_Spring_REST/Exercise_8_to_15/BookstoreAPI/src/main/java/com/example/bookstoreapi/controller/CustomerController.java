package com.example.bookstoreapi.controller;
import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
//import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private List<Customer> customerList = new ArrayList<>();
    private final ModelMapper modelMapper;

    public CustomerController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customerOptional = customerList.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
        return customerOptional.map(customer -> new ResponseEntity<>(modelMapper.map(customer, CustomerDTO.class), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@jakarta.validation.Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerList.add(customer);
        CustomerDTO createdCustomerDTO = modelMapper.map(customer, CustomerDTO.class);
        return new ResponseEntity<>(createdCustomerDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long id, @jakarta.validation.Valid @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerList.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setName(customerDTO.getName());
            customer.setEmail(customerDTO.getEmail());
            customer.setAddress(customerDTO.getAddress());
            CustomerDTO updatedCustomerDTO = modelMapper.map(customer, CustomerDTO.class);
            return new ResponseEntity<>(updatedCustomerDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        boolean removed = customerList.removeIf(customer -> customer.getId().equals(id));
        return removed ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}