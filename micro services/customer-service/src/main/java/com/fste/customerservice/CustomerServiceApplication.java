package com.fste.customerservice;

import com.fste.customerservice.Entities.Customer;
import com.fste.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(CustomerRepository CustomerRepository) {
        return args -> {
            CustomerRepository.save(Customer.builder()
                    .id(Long.valueOf(1))
                    .lastName("ERRACHIDI")
                    .firstName("Imad")
                    .build());
            CustomerRepository.save(Customer.builder()
                    .id(Long.valueOf(2))
                    .firstName("Afaf")
                    .lastName("EERRACHIDI")
                    .build());

        };

    }}
