package com.bank.bankapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.bankapp.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{

}
