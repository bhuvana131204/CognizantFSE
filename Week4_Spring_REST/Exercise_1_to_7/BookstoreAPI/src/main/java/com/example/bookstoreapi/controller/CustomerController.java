package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerList.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam("name") String name,
                                                     @RequestParam("email") String email,
                                                     @RequestParam("address") String address) {
        Customer customer = new Customer();
        customer.setId((long) (customerList.size() + 1));
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customerList.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}
