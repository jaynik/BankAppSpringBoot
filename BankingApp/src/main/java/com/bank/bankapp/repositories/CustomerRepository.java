package com.bank.bankapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bank.bankapp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
