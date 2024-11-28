package com.fste.accountservice;

import com.fste.accountservice.Entites.Account;
import com.fste.accountservice.models.AccountStatus;
import com.fste.accountservice.models.AccountType;
import com.fste.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AccountRepository accountRepository) {
        return args -> {
            accountRepository.save(Account.builder()
                    .id(Long.valueOf(1))
                    .type(AccountType.CURRENT_ACCOUNT)
                    .date_creation(LocalDate.now())
                    .status(AccountStatus.CREATED_ACCOUNT)
                    .customer_Id(Long.valueOf(1))
                    .build());
            accountRepository.save(Account.builder()
                    .id(Long.valueOf(2))
                    .type(AccountType.SAVING_ACCOUNT)
                    .date_creation(LocalDate.now())
                    .status(AccountStatus.CREATED_ACCOUNT)
                    .customer_Id(Long.valueOf(1))
                    .build());
            accountRepository.save(Account.builder()
                    .id(Long.valueOf(3))
                    .type(AccountType.SAVING_ACCOUNT)
                    .date_creation(LocalDate.now())
                    .status(AccountStatus.SUSPENDED_ACCOUNT)
                    .customer_Id(Long.valueOf(2))
                    .build());
            accountRepository.save(Account.builder()
                    .id(Long.valueOf(4))
                    .type(AccountType.CURRENT_ACCOUNT)
                    .date_creation(LocalDate.now())
                    .status(AccountStatus.SUSPENDED_ACCOUNT)
                    .customer_Id(Long.valueOf(2))
                    .build());
        };
        };

    }

