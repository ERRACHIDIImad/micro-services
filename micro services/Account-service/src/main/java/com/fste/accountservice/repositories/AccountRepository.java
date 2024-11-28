package com.fste.accountservice.repositories;

import com.fste.accountservice.Entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account,Long> {
}
