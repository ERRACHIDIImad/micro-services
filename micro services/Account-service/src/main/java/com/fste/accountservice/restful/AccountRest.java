package com.fste.accountservice.restful;

import com.fste.accountservice.Entites.Account;
import com.fste.accountservice.RestClients.CustomerClient;
import com.fste.accountservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRest {

     AccountRepository accountRepository;
     CustomerClient customerClient;


    public AccountRest(CustomerClient customerClient,AccountRepository accountRepository){
        this.customerClient=customerClient;
        this.accountRepository=accountRepository;

    }

    @GetMapping("/allAccounts")
    public List<Account> getAccounts(){
        List<Account> accounts= this.accountRepository.findAll();
        accounts.forEach(account->{
            account.setCustomer(
                    customerClient.getCustomer(account.getCustomer_Id())
            );
        });
        return accounts;
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id){
        Account account= this.accountRepository.findById(id).get();
        account.setCustomer(customerClient.getCustomer(account.getCustomer_Id()));
        return account;
    }

}
