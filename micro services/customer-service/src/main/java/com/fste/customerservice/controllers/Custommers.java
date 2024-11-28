package com.fste.customerservice.controllers;


import com.fste.customerservice.Entities.Customer;
import com.fste.customerservice.repositories.CustomerRepository;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Custommers {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/api/customers")
    public List<Customer> getCustomers(){
        return this.customerRepository.findAll();
    }

    @GetMapping("/api/costumer/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return this.customerRepository.findById(id).get();
    }

}
