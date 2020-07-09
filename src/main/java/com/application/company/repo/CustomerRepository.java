package com.application.company.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.company.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
