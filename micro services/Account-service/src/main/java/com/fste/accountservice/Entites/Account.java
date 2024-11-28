package com.fste.accountservice.Entites;

import com.fste.accountservice.models.AccountStatus;
import com.fste.accountservice.models.AccountType;
import com.fste.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity @Builder @AllArgsConstructor @NoArgsConstructor
@Data
public class Account {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDate date_creation;
    private AccountType type;
    private AccountStatus status;
    private Long customer_Id ;
    @Transient
    private Customer customer;

}
