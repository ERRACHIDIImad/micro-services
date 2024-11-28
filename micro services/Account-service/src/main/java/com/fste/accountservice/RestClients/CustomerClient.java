package com.fste.accountservice.RestClients;


import com.fste.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CUSTOMER-SERVICE")
public interface CustomerClient {

    @GetMapping("/api/costumer/{id}")
    @CircuitBreaker(name = "Customer" , fallbackMethod = "notFoundCustomer")
     Customer getCustomer(@PathVariable Long id);

    @GetMapping("/api/customers")
     List<Customer> allCustomers();

     default Customer notFoundCustomer(Long id,Exception exception){
     return Customer.builder()
             .lastName("customer not found")
             .firstName("customer not found").build();
}


}
